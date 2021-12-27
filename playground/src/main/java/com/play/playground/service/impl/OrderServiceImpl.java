package com.play.playground.service.impl;

import com.play.playground.config.DelayTaskConfig;
import com.play.playground.dao.FieldDao;
import com.play.playground.dao.OrderDao;
import com.play.playground.dao.UserDao;
import com.play.playground.entity.Field;
import com.play.playground.entity.Order;
import com.play.playground.entity.User;
import com.play.playground.service.OrderService;
import com.play.playground.util.Result;
import com.play.playground.util.StaticUtil;
import com.play.playground.vo.AttendVO;
import com.play.playground.vo.OrderResultVO;
import com.play.playground.vo.OrderSearchVO;
import com.play.playground.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    FieldDao fieldDao;

    @Autowired
    UserDao userDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DelayTaskConfig delayTaskConfig;

    // 预约业务
    @Transactional
    public Result order(OrderVO orderVO){
        Field targetField = fieldDao.getOne(orderVO.generateFieldIdWrapper());
        User targetUser = userDao.getOne(orderVO.generateUserIdWrapper());
        if(targetUser.getStatus().equals("失信"))
            return Result.failed("用户处于失信状态，请稍后尝试");
        if(targetField.getStatus().equals("不可用"))
            return Result.failed("当前场地不可用，请稍后尝试");

//        if(orderVO.getStartDateTime().plusMinutes(30).isBefore(orderVO.getOrderDateTime())){
//            return Result.failed("不能预约早于当前时间的场地");
//        }
        // 如果当前时间段已经被预约
        int[] timeSection = StaticUtil.initTimeSection();
        List<Order> orders = orderDao.searchFieldTodayCondition(orderVO.generateIdAndDateWrapper());
        for(Order order : orders){
            timeSection = StaticUtil.getTimeSection(order.getStartTime(), order.getEndTime(), timeSection);
        }
        if(StaticUtil.isRedundancy(orderVO.getStartDateTime(), orderVO.getEndDateTime(), timeSection)){
            return Result.failed("当前时间段已经被预约");
        }
        Order targetOrder = new Order();
        targetOrder.setUserId(orderVO.getUserId());
        targetOrder.setEndTime(orderVO.getEndDateTime());
        targetOrder.setStartTime(orderVO.getStartDateTime());
        targetOrder.setOrderTime(orderVO.getOrderDateTime());
        targetOrder.setFieldId(orderVO.getFieldId());
        targetOrder.setStatus("未签到");
        orderDao.save(targetOrder);
        this.sendOrderMessage(targetOrder.getId(), 1);
        return Result.ok(targetOrder);
    }

    // 签到业务
    @Transactional
    public Result attend(AttendVO attendVO){
        Order order = orderDao.getOne(attendVO.generateOrderIdWrapper());
        if(!order.getStatus().equals("未签到")){
            return Result.failed(String.format("签到失败，当前预约状态：%s", order.getStatus()));
        }
        order.setStatus("已签到");
        if(orderDao.updateById(order)){
            sendAttendMessage(order.getId(), 1);
            return Result.ok("签到成功");
        }
        else
            return Result.failed("签到失败");
    }

    @Override
    public List<OrderResultVO> searchOrder(OrderSearchVO orderSearchVO) {
        List<OrderResultVO> orderResultVOS = orderDao.searchOrder(orderSearchVO.generateWrapper());
        return orderResultVOS;
    }

    // 发送端
    private void sendOrderMessage(Long orderId, int delayTime){
        log.info("===============延时队列生产消息====================");
        log.info("发送时间:{},发送内容:{}", LocalDateTime.now(), orderId);
        this.rabbitTemplate.convertAndSend(
            delayTaskConfig.DELAY_EXCHANGE,
            delayTaskConfig.ORDER_KEY,
            orderId,
            message -> {
                message.getMessageProperties().setHeader("x-delay", delayTime * 60000);
                return message;
            }
        );
    }


    private void sendBlackMessage(Long userId, int delayTime){
        log.info("===============延时队列生产消息====================");
        log.info("发送时间:{},发送内容:{}", LocalDateTime.now(), userId);
        this.rabbitTemplate.convertAndSend(
                delayTaskConfig.DELAY_EXCHANGE,
                delayTaskConfig.BLACK_KEY,
                userId,
                message -> {
                    message.getMessageProperties().setHeader("x-delay", delayTime * 60000);
                    return message;
                }
        );
    }
    private void sendAttendMessage(Long orderId, int delayTime){
        log.info("===============延时队列生产消息====================");
        log.info("发送时间:{},发送内容:{}", LocalDateTime.now(), orderId);
        this.rabbitTemplate.convertAndSend(
                delayTaskConfig.DELAY_EXCHANGE,
                delayTaskConfig.BLACK_KEY,
                orderId,
                message -> {
                    message.getMessageProperties().setHeader("x-delay", delayTime * 60000);
                    return message;
                }
        );
    }


    @RabbitListener(queues = DelayTaskConfig.ORDER_QUEUE)
    @RabbitHandler
    @Transactional
    public void orderReceiveDelay(Long orderId, Message message) throws IOException {
        log.info("===(未签到任务)接收队列接收消息====================");
        log.info("接收时间:{},接受内容:{}", LocalDateTime.now(), orderId);
        Order targetOrder = orderDao.getById(orderId);
        if(targetOrder != null && targetOrder.getStatus().equals("未签到")){
            targetOrder.setStatus("未签到结束");
            orderDao.updateById(targetOrder);
            User targetUser = userDao.getById(targetOrder.getUserId());
            if(targetUser != null){
                targetUser.setStatus("失信");
                sendBlackMessage(targetOrder.getUserId(), 1);
                userDao.updateById(targetUser);
            }
        }
    }

    @RabbitListener(queues = DelayTaskConfig.BLACK_QUEUE)
    @RabbitHandler
    public void blackUserReceiveDelay(Long userId, Message message) throws IOException {
        log.info("===(移除黑名单任务)接收队列接收消息====================");
        log.info("接收时间:{},接受内容:{}", LocalDateTime.now(), userId);
        User targetUser = userDao.getById(userId);

        if(targetUser != null && targetUser.getStatus().equals("失信")){
            targetUser.setStatus("正常");
            userDao.updateById(targetUser);
        }
    }


    @RabbitListener(queues = DelayTaskConfig.ATTEND_QUEUE)
    @RabbitHandler
    public void attendOrderReceiveDelay(Long orderId, Message message) throws IOException {
        log.info("===(移除黑名单任务)接收队列接收消息====================");
        log.info("接收时间:{},接受内容:{}", LocalDateTime.now(), orderId);
        Order targetOrder = orderDao.getById(orderId);
        if(targetOrder  != null && targetOrder.getStatus().equals("已签到")){
            targetOrder.setStatus("正常结束");
            orderDao.updateById(targetOrder);
        }
    }
}
