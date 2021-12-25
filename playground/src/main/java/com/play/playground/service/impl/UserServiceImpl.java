package com.play.playground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.play.playground.dao.UserDao;
import com.play.playground.entity.User;
import com.play.playground.mapper.UserMapper;
import com.play.playground.service.UserService;
import com.play.playground.util.Result;
import com.play.playground.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserDao userDao;


    public Result Login(LoginVO loginVO){
        User user = userDao.getOne(loginVO.generateUserByPhoneWrapper());

        if(user == null) return Result.failed("不存在此用户");

        if(user.getPassword().equals(loginVO.getPassword()))
            return Result.ok(user);
        else
            return Result.failed("密码错误");
    }

}
