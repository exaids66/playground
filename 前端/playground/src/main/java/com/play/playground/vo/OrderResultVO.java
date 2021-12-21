package com.play.playground.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel("预约结果对象")
@Data
@ToString
public class OrderResultVO {

    private String username;

    private Integer userId;



}
