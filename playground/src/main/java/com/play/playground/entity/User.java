package com.play.playground.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (USER)实体类
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("USER")
public class User extends Model<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @TableField()
    @ApiParam("用户ID")
	private Long  id;
    /**
     * 用户名
     */
    @ApiParam("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiParam("密码")
    private String password;
    /**
     * 昵称
     */
    @ApiParam("昵称")
    private String nickname;
    /**
     * 是否加入黑名单
     */
    @ApiParam("黑名单状态(正常|失信)")
    private String status;
    /**
     * 手机号
     */
    @ApiParam("手机号")
    private String phone;

}