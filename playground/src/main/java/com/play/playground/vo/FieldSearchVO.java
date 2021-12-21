package com.play.playground.vo;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.play.playground.util.StaticUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("小场地搜索表单对象")
@Data
public class FieldSearchVO {

    @ApiModelProperty(name = "球场状态", notes = "前端传入,用于筛选可用球场(可用|不可用)")
    private String status;

    @ApiModelProperty(name = "小球场类型", notes = "前端传入,用于按球场类型分类(羽毛球场|足球场|篮球场|排球场|乒乓球场)")
    private String type;

    @ApiModelProperty(name = "大场地ID", notes = "前端传入,用于按场地类型分类")
    private Integer groundID;


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
