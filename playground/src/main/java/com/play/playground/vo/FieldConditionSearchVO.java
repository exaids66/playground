package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.play.playground.entity.Order;
import com.play.playground.util.StaticUtil;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FieldConditionSearchVO {

    @ApiParam(value = "小场地ID", required = true)
    private Long fieldId;


    @ApiParam(value = "查询某一天场地可用情况，默认传当前时间即可", required = true)
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    public QueryWrapper generateIdAndDateWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("FIELD.ID", fieldId);
        queryWrapper.in("`ORDER`.STATUS", new String[]{"待签到", "已签到", "正常结束"});
        queryWrapper.apply("TO_DAYS(`ORDER`.START_TIME) = TO_DAYS({0})", dateTime);
        return queryWrapper;
    }

    public FieldTodayConditionVO generateFieldConditionSearchVO(List<Order> orders){
        int[] timeSection = StaticUtil.initTimeSection();
        for(Order order : orders)
            StaticUtil.getTimeSection(order.getStartTime(), order.getEndTime(), timeSection);
        FieldTodayConditionVO res = new FieldTodayConditionVO();
        res.setTimeSection(timeSection);
        res.setDate(dateTime);
        res.setFieldId(fieldId);
        return res;
    }

}
