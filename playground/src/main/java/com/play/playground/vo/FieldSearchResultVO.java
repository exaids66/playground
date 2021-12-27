package com.play.playground.vo;


import com.play.playground.entity.Field;
import com.play.playground.entity.Playground;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("小场地搜索返回结果对象")
public class FieldSearchResultVO {

    @ApiModelProperty(value = "小场地ID")
    private Long fieldId;
    /**
     * 场地类型(羽毛球|篮球|排球|乒乓球|田径场地)
     */
    @ApiModelProperty(value = "场地类型(羽毛球|篮球|排球|乒乓球|田径场地)")
    private String type;
    /**
     * 运动场地ID
     */
    @ApiModelProperty("运动场地ID")
    private Long groundId;
    /**
     * 地点
     */
    @ApiModelProperty("小场地地点")
    private String fieldAddress;
    /**
     * 状态(可用|不可用)
     */
    @ApiModelProperty("状态(可用|不可用)")
    private String status;
    /**
     * 场地名称
     */
    @ApiModelProperty("场地名称")
    private String fieldName;

    @ApiModelProperty("大场地ID")
    private Long playgroundId;
    /**
     * 场地名称
     */
    @ApiModelProperty("场地名称")
    private String groundName;
    /**
     * 地址
     */
    @ApiModelProperty("大场地地址")
    private String playgroundAddress;
    /**
     * 管理员名称
     */
    @ApiModelProperty("管理员名称")
    private String adminName;
    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String contact;
    /**
     * 开馆时间
     */
    @ApiModelProperty("开馆时间")
    private Date openTime;
    /**
     * 闭馆时间
     */
    @ApiModelProperty("闭馆时间")
    private Date closeTime;

}
