package com.play.playground.dao;

import lombok.extern.slf4j.Slf4j;
import com.play.playground.entity.Order;
import com.play.playground.mapper.OrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * (ORDER)数据DAO
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Repository
public class OrderDao extends ServiceImpl<OrderMapper, Order> {

}