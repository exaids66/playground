package com.play.playground.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.dao.PlaygroundDao;
import com.play.playground.entity.Playground;
import com.play.playground.mapper.PlaygroundMapper;
import com.play.playground.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.play.playground.util.Result.ok;

@RestController
@RequestMapping("/ground")
@Api(tags = "场地管理模块", description = "场地管理模块")
public class PlayGroundController {

    @Autowired
    private PlaygroundDao playgroundDao;
    @Autowired
    private PlaygroundMapper playgroundMapper;

    @GetMapping("/all")
    public Result getAllGroundInfo(Page page){
        return Result.ok(playgroundDao.page(page));
    }

    @PostMapping("/search/{s}")
    public Result Register(@PathVariable(name="s") String s){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("GROUND_NAME",s);
        List<Playground> list=playgroundMapper.selectList(queryWrapper);

        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("ADDRESS",s);
        List<Playground> list1=playgroundMapper.selectList(wrapper);
        for(int i=0;i<list1.size();i++){
            if( list.contains(list1.get(i)) !=true ){
                list.add(list.get(i));
            }
        }

        return ok(list);
    }
}
