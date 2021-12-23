package com.play.playground.service.impl;

import com.play.playground.dao.FieldDao;
import com.play.playground.dao.OrderDao;
import com.play.playground.dao.UserDao;
import com.play.playground.entity.Field;
import com.play.playground.entity.Order;
import com.play.playground.entity.User;
import com.play.playground.service.OrderService;
import com.play.playground.util.Result;
import com.play.playground.vo.AttendVO;
import com.play.playground.vo.OrderResultVO;
import com.play.playground.vo.OrderSearchVO;
import com.play.playground.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    FieldDao fieldDao;

    @Autowired
    UserDao userDao;


    // 预约业务
    @Transactional
    public Result order(OrderVO orderVO){
        Field targetField = fieldDao.getOne(orderVO.generateFieldIdWrapper());
        User targetUser = userDao.getOne(orderVO.generateUserIdWrapper());
        if(targetUser.getStatus().equals("失信"))
            return Result.failed("用户处于失信状态，请稍后尝试");
        if(targetField.getStatus().equals("不可用"))
            return Result.failed("当前场地不可用，请稍后尝试");
        if(orderVO.getStartDateTime().plusMinutes(30).isBefore(orderVO.getOrderDateTime())){
            return Result.failed("不能预约早于当前时间的场地");
        }
        // TODO 如果当前时间段已经被预约，查询待写
        if(false){
            return Result.failed("当前时间段已经被预约");
        }
        Order targetOrder = new Order();
        targetOrder.setUserId(orderVO.getUserId());
        targetOrder.setEndTime(orderVO.getEndDateTime());
        targetOrder.setStartTime(orderVO.getEndDateTime());
        targetOrder.setOrderTime(orderVO.getOrderDateTime());
        targetOrder.setFieldId(orderVO.getFieldId());
//        targetOrder.setId(11);
        targetOrder.setStatus("未签到");
        orderDao.save(targetOrder);
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
        if(orderDao.updateById(order))
            return Result.ok("签到成功");
        else
            return Result.failed("签到失败");
    }

    @Override
    public List<OrderResultVO> searchOrder(OrderSearchVO orderSearchVO) {
        List<OrderResultVO> orderResultVOS = orderDao.searchOrder(orderSearchVO.generateWrapper());
        return orderResultVOS;
    }
}
