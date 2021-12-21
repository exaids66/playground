package com.play.playground.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.dao.FieldDao;
import com.play.playground.service.FieldService;
import com.play.playground.util.Result;
import com.play.playground.vo.FieldSearchResultVO;
import com.play.playground.vo.FieldSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    FieldDao fieldDao;

    public Result searchField(FieldSearchVO fieldSearchVO, Page page){
        IPage<FieldSearchResultVO> iPage =
                fieldDao.getBaseMapper()
                        .searchField(fieldSearchVO.generateWrapper(), page);
        return Result.ok(iPage);
    }

}
