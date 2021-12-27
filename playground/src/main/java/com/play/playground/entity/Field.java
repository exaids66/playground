<<<<<<< HEAD
package com.play.playground.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (FIELD)实体类
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("FIELD")
public class Field extends Model<Field> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
	private Integer id;
    /**
     * 场地类型(羽毛球|篮球|排球|乒乓球|田径场地)
     */
    private String type;
    /**
     * 运动场地ID
     */
    private Integer groundId;
    /**
     * 地点
     */
    private String address;
    /**
     * 状态(可用|不可用)
     */
    private String status;
    /**
     * 场地名称
     */
    private String fieldName;

=======
package com.play.playground.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (FIELD)实体类
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("FIELD")
public class Field extends Model<Field> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiParam(value = "小场地ID")
	private Long id;
    /**
     * 场地类型(羽毛球|篮球|排球|乒乓球|田径场地)
     */
    @ApiParam(value = "场地类型(羽毛球|篮球|排球|乒乓球|田径场地)")
    private String type;
    /**
     * 运动场地ID
     */
    @ApiParam(value = "运动场地ID")
    private Long groundId;
    /**
     * 地点
     */
    @ApiParam( value = "小场地地点")
    private String address;
    /**
     * 状态(可用|不可用)
     */
    @ApiParam( value = "状态(可用|不可用)")
    private String status;
    /**
     * 场地名称
     */
    @ApiParam(value = "场地名称")
    private String fieldName;

>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
}