package com.play.playground.service;


import com.play.playground.util.Result;
import com.play.playground.vo.LoginVO;
import org.springframework.stereotype.Service;


public interface UserService {

    Result Login(LoginVO loginVO);
}
