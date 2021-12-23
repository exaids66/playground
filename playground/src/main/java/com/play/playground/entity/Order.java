package com.play.playground.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (ORDER)实体类
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("`ORDER`")
public class Order extends Model<Order> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
//    @TableId(type = IdType.NONE)
    @ApiParam(value = "预约号ID")
	private Long id;
    /**
     * 预约时间
     */
    @ApiParam(value = "预约时间（指什么时候提交的预约申请），前端填入请求时间即可, （时间字段必须是yyyy-MM-dd HH:mm:ss的格式 eg:8点必须写成 08:00:00）")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;
    /**
     * 预约开始时间(小时)
     */
    @ApiParam(value = "预约开始时间，（时间字段必须是yyyy-MM-dd HH:mm:ss的格式 eg:8点必须写成 08:00:00）")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    /**
     * 预约结束时间(小时)
     */
    @ApiParam(value = "预约结束时间，（时间字段必须是yyyy-MM-dd HH:mm:ss的格式 eg:8点必须写成 08:00:00）")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    /**
     * 预约状态(待签到|已签到|未签到结束|正常结束)
     */
    @ApiParam(value = "预约状态(待签到|已签到|未签到结束|正常结束)")
    private String status;
    /**
     * 用户ID
     */
    @ApiParam(value = "用户ID")
    private Long userId;
    /**
     * 运动场ID
     */
    @ApiParam(value = "小场地ID")
    private Long fieldId;

}