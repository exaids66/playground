package com.play.playground.controller;


import com.play.playground.dao.UserDao;
import com.play.playground.service.UserService;
import com.play.playground.util.Result;
import com.play.playground.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController()
@Api(tags = "用户管理模块", description = "用户管理模块")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("登入")
    @PostMapping("/login")
    public Result doLogin(LoginVO loginVO){
        return userService.Login(loginVO);
    }


}
