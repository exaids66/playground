package com.play.playground.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.util.Result;
import com.play.playground.vo.FieldSearchVO;

public interface FieldService {

    Result searchField(FieldSearchVO fieldSearchVO, Page page);

}
