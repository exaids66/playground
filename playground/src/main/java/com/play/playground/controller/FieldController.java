package com.play.playground.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.entity.Field;
import com.play.playground.service.FieldService;
import com.play.playground.util.Result;
import com.play.playground.vo.FieldConditionSearchVO;
import com.play.playground.vo.FieldSearchResultVO;
import com.play.playground.vo.FieldSearchVO;
import com.play.playground.vo.FieldTodayConditionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RestController
@RequestMapping("/field")
@Api(tags = "小场地管理模块", description = "小场地管理模块")
public class FieldController {

    @Autowired
    FieldService fieldService;



    @GetMapping()
    @ApiOperation(value = "小场地基本信息查询接口")
    public IPage<FieldSearchResultVO> searchField(FieldSearchVO fieldSearchVO, Page page){

        return fieldService.searchField(fieldSearchVO, page);
    }

    @GetMapping("/today")
    @ApiOperation(value = "根据场地ID获得当天场地可用情况")
    public FieldTodayConditionVO getTodayFieldCondition(
            FieldConditionSearchVO fieldConditionSearchVO){
        return fieldService.searchFieldTodayCondition(fieldConditionSearchVO);
    }


}
