package com.play.playground.service;


<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.extension.service.IService;
import com.play.playground.entity.User;
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
import com.play.playground.util.Result;
import com.play.playground.vo.LoginVO;
import org.springframework.stereotype.Service;


<<<<<<< HEAD
public interface UserService {
=======
public interface UserService extends IService<User> {
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52

    Result Login(LoginVO loginVO);
}
