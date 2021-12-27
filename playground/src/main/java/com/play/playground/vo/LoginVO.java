package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
<<<<<<< HEAD
=======
import io.swagger.annotations.ApiModelProperty;
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("登入表单对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private String phone;

    private String password;

    public AbstractWrapper generateUserByPhoneWrapper(){
        QueryWrapper  wrapper = new QueryWrapper();
        wrapper.eq("PHONE", phone);
        return wrapper;
    }
}
