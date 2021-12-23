package com.play.playground.controller;


import com.play.playground.service.OrderService;
import com.play.playground.util.Result;
import com.play.playground.vo.AttendVO;
import com.play.playground.vo.OrderResultVO;
import com.play.playground.vo.OrderSearchVO;
import com.play.playground.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/order")
@RestController()
@Api(tags = "预约管理模块", description = "预约管理模块")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation("搜索用户预约信息")
    @GetMapping("/result")
    public List<OrderResultVO> getOrderResult(OrderSearchVO orderSearchVO){
        return orderService.searchOrder(orderSearchVO);
    }


    @ApiOperation("用户预约小场地")
    @PostMapping("/order")
    @Transactional
    public Result order(OrderVO orderVO){
        return orderService.order(orderVO);
    }


    @ApiOperation("签到")
    @PostMapping("/attend")
    @Transactional
    public Result attend(AttendVO attendVO){
        return orderService.attend(attendVO);
    }

}
