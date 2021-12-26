package com.play.playground.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.play.playground.entity.Order;
import com.play.playground.util.StaticUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@ApiModel("当天场地可用情况查询结果对象")
@Data
public class FieldTodayConditionVO {

    private Long fieldId;

    @ApiModelProperty("数组，0~23，1表示不可用，0表示可用")
    private int[] timeSection;

    @ApiModelProperty(value = "查询的时间，可以传当前时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;


}
