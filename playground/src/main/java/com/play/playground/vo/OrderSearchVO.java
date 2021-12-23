package com.play.playground.vo;


import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class OrderSearchVO {

    @ApiParam(value = "预约状态")
    private String orderStatus;

    @ApiParam(value = "用户ID")
    private Long userId;

    @ApiParam(value = "小场地ID")
    private Long fieldId;

}
