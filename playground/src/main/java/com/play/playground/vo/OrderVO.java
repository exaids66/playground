package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OrderVO {

    @ApiParam(value = "用户ID")
    private Long userId;

    @ApiParam(value = "小场地ID")
    private Long fieldId;

    @ApiParam(format = "yyyy-MM-dd HH:mm:ss", value = "开始使用时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;

    @ApiParam(format = "yyyy-MM-dd HH:mm:ss", value = "使用结束时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;

    @ApiParam(format = "yyyy-MM-dd HH:mm:ss", value = "预约时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDateTime;

    public QueryWrapper generateUserIdWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("USER.ID", userId);
        return queryWrapper;
    }

    public QueryWrapper generateFieldIdWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("FIELD.ID", fieldId);
        return queryWrapper;
    }

}
