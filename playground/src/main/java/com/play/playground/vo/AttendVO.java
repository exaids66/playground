package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class AttendVO {


    private Long userId;

    @ApiParam(value = "预约ID, 只填这个就可以")
    private Long orderId;

    private Long fieldId;


    public QueryWrapper generateOrderIdWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("ORDER.ID", orderId);
        return queryWrapper;
    }

}
