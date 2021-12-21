package com.play.playground.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@TableName("ORDER")
public class Order extends Model<Order> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Integer id;
    /**
     * 预约时间
     */
    private Date orderTime;
    /**
     * 预约开始时间(小时)
     */
    private Date startTime;
    /**
     * 预约结束时间(小时)
     */
    private Date endTime;
    /**
     * 预约状态(空闲|预约|使用)
     */
    private String status;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 运动场ID
     */
    private Integer fieldId;

}