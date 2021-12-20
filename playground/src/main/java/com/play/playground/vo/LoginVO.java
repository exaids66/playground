package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
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
