package com.play.playground.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.play.playground.entity.User;
import com.play.playground.util.Result;
import com.play.playground.vo.LoginVO;
import org.springframework.stereotype.Service;


public interface UserService extends IService<User> {

    Result Login(LoginVO loginVO);
}
