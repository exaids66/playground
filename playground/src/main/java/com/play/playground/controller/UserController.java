package com.play.playground.controller;


<<<<<<< HEAD
import com.play.playground.dao.UserDao;
=======
import cn.hutool.core.bean.BeanUtil;
import com.play.playground.dao.UserDao;
import com.play.playground.entity.User;
import com.play.playground.mapper.UserMapper;
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
import com.play.playground.service.UserService;
import com.play.playground.util.Result;
import com.play.playground.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
@Api("用户操作接口")
=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.play.playground.util.Result.ok;

@RequestMapping("/user")
@RequestMapping("/user")
@RestController()
@Api(tags = "用户管理模块", description = "用户管理模块")
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
public class UserController {

    @Autowired
    UserService userService;
<<<<<<< HEAD

    @ApiOperation("登入")
    @PostMapping("/login")
    public Result doLogin(LoginVO loginVO){
        return userService.Login(loginVO);
    }

=======
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "登入模块")
    @PostMapping("/login")
    public Result doLogin(@RequestBody LoginVO loginVO){
        return userService.Login(loginVO);
    }

    @PostMapping("/register")
    public Result Register(@RequestBody User user){
        List<User> list=userMapper.selectList(null);
        long num=0;
        for(int i=0;i<list.size();i++){
            num=Math.max(list.get(i).getId(),num);
        }
        num++;

        User u=new User();
        user.setStatus("正常");
        user.setId(num);
        BeanUtil.copyProperties(user,u);
        userService.saveOrUpdate(user);

        return ok("注册成功");
    }
//    @PostMapping("/")
//    public Result doLogin(String phone, String password){
//        return userService.Login(new LoginVO(phone, password));
//    }
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52

}
