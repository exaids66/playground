<<<<<<< HEAD
package com.play.playground.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel("预约结果对象")
@Data
@ToString
public class OrderResultVO {

    private String username;

    private Integer userId;



}
=======
package com.play.playground.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ApiModel("预约结果对象")
@Data
@ToString
public class OrderResultVO {

    @ApiModelProperty(value = "预约号ID")
    private Long orderId;
    /**
     * 预约时间
     */
    @ApiModelProperty(value = "预约时间（指什么时候提交的预约申请），前端填入请求时间即可, （时间字段必须是yyyy-MM-dd HH:mm:ss的格式 eg:8点必须写成 08:00:00）")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;
    /**
     * 预约开始时间(小时)
     */
    @ApiModelProperty(value = "预约开始时间，（时间字段必须是yyyy-MM-dd HH:mm:ss的格式 eg:8点必须写成 08:00:00）")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    /**
     * 预约结束时间(小时)
     */
    @ApiModelProperty(value = "预约结束时间，（时间字段必须是yyyy-MM-dd HH:mm:ss的格式 eg:8点必须写成 08:00:00）")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    /**
     * 预约状态(待签到|已签到|未签到结束|正常结束)
     */
    @ApiModelProperty(value = "预约状态(待签到|已签到|未签到结束|正常结束)")
    private String orderStatus;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 运动场ID
     */
    @ApiModelProperty(value = "小场地ID")
    private Long fieldId;

    @ApiModelProperty(value = "小场地名称")
    private String fieldName;

    @ApiModelProperty("小场地地址")
    private String fieldAddress;

    @ApiModelProperty(value = "小场地类型")
    private String fieldType;


    @ApiModelProperty("用户名")
    private String username;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 是否加入黑名单
     */
    @ApiModelProperty("黑名单状态(正常|失信)")
    private String userStatus;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 场地名称
     */
    @ApiModelProperty("大场地ID")
    private Long groundId;

    @ApiModelProperty("大场地名称")
    private String groundName;
}
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
