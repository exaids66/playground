package com.play.playground.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.dao.PlaygroundDao;
import com.play.playground.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ground")
@Api(tags = "场地管理模块", description = "场地管理模块")
public class PlayGroundController {

    @Autowired
    private PlaygroundDao playgroundDao;

    @GetMapping("/all")
    public Result getAllGroundInfo(Page page){
        return Result.ok(playgroundDao.page(page));
    }
}
