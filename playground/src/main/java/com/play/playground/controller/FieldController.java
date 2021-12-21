package com.play.playground.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.service.FieldService;
import com.play.playground.util.Result;
import com.play.playground.vo.FieldSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/field")
@Api(tags = "小场地管理模块", description = "小场地管理模块")
public class FieldController {

    @Autowired
    FieldService fieldService;

    @GetMapping()
    public Result searchField(@ApiParam(name="搜索项") FieldSearchVO fieldSearchVO, @ApiParam(name = "分页项") Page page){

        return fieldService.searchField(fieldSearchVO, page);
    }



}
