package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.play.playground.util.StaticUtil;
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

    public QueryWrapper generateWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        if(!StaticUtil.isNullOrEmpty(orderStatus))
            queryWrapper.eq("ORDER.STATUS", orderStatus);
        if(userId != null)
            queryWrapper.eq("USER.ID", userId);
        if(fieldId != null)
            queryWrapper.eq("FIELD.ID", fieldId);
        return queryWrapper;
    }
}
