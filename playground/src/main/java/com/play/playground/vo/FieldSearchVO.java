package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.play.playground.util.StaticUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class FieldSearchVO {

//    @ApiModelProperty(name = "球场状态", notes = "前端传入,用于筛选可用球场(可用|不可用)")
    @ApiParam(value = "球场状态,前端传入,用于筛选可用球场(可用|不可用)")
    private String status;

    @ApiParam(value = "小球场类型,前端传入,用于按球场类型分类(羽毛球场|足球场|篮球场|排球场|乒乓球场)")
    private String type;

    @ApiParam(value = "大场地ID 前端传入,用于按场地类型分类")
    private Long groundID;


    public QueryWrapper generateWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        if(!StaticUtil.isNullOrEmpty(status))
            queryWrapper.eq("FIELD.STATUS", status);
        if(!StaticUtil.isNullOrEmpty(type))
            queryWrapper.eq("FIELD.TYPE", type);
        if(groundID != null)
            queryWrapper.eq("FIELD.GROUND_ID", groundID);
        return queryWrapper;
    }
}
