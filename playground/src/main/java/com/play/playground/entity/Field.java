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

}