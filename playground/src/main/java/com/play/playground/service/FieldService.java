package com.play.playground.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.util.Result;
import com.play.playground.vo.FieldSearchResultVO;
import com.play.playground.vo.FieldSearchVO;

import java.util.List;

public interface FieldService {

    IPage<FieldSearchResultVO> searchField(FieldSearchVO fieldSearchVO, Page page);

}
