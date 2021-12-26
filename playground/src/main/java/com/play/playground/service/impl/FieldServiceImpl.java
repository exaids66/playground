package com.play.playground.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.dao.FieldDao;
import com.play.playground.dao.OrderDao;
import com.play.playground.entity.Order;
import com.play.playground.service.FieldService;
import com.play.playground.util.Result;
import com.play.playground.util.StaticUtil;
import com.play.playground.vo.FieldConditionSearchVO;
import com.play.playground.vo.FieldSearchResultVO;
import com.play.playground.vo.FieldSearchVO;
import com.play.playground.vo.FieldTodayConditionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    FieldDao fieldDao;

    @Autowired
    OrderDao orderDao;

    public IPage<FieldSearchResultVO> searchField(FieldSearchVO fieldSearchVO, Page page){
        IPage<FieldSearchResultVO> iPage =
                fieldDao.getBaseMapper()
                        .searchField(fieldSearchVO.generateWrapper(), page);
        return iPage;
    }


    public FieldTodayConditionVO searchFieldTodayCondition(FieldConditionSearchVO fieldConditionSearchVO){
        List<Order> orders = orderDao.searchFieldTodayCondition(fieldConditionSearchVO.generateIdAndDateWrapper());
        FieldTodayConditionVO res = fieldConditionSearchVO.generateFieldConditionSearchVO(orders);
        return res;
    }
}
