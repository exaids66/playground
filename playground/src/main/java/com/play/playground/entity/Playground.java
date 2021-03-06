<<<<<<< HEAD
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
 * (PLAYGROUND)实体类
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("PLAYGROUND")
public class Playground extends Model<Playground> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
	private Integer id;
    /**
     * 场地名称
     */
    private String groundName;
    /**
     * 地址
     */
    private String address;
    /**
     * 管理员名称
     */
    private String adminName;
    /**
     * 联系方式
     */
    private String contact;
    /**
     * 开馆时间
     */
    private Date openTime;
    /**
     * 闭馆时间
     */
    private Date closeTime;

=======
package com.play.playground.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (PLAYGROUND)实体类
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("PLAYGROUND")
public class Playground extends Model<Playground> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiParam("大场地ID")
	private Long id;
    /**
     * 场地名称
     */
    @ApiParam("大场地名称")
    private String groundName;
    /**
     * 地址
     */
    @ApiParam(value = "大场地地址")
    private String address;

    /**
     * 管理员名称
     */
    @ApiParam(value = "管理员名称")
    private String adminName;

    /**
     * 联系方式
     */
    @ApiParam(value = "管理员联系方式")
    private String contact;
    /**
     * 开馆时间
     */
    private Date openTime;
    /**
     * 闭馆时间
     */
    private Date closeTime;

>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
}