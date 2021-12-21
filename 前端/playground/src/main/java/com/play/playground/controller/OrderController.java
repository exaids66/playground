package com.play.playground.controller;


import com.play.playground.vo.OrderResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/order")
@Controller
@RestController
@Api("预约管理模块")
public class OrderController {
    @ApiOperation("按用户ID获得所有的预约结果")
    @GetMapping("/result")
    public List<OrderResultVO> getOrderResultByUserId(){
        return null;
    }

}
