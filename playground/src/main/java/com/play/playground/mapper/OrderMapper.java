<<<<<<< HEAD
package com.play.playground.mapper;

import com.play.playground.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (ORDER)数据Mapper
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
=======
package com.play.playground.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.play.playground.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.play.playground.vo.OrderResultVO;
import com.play.playground.vo.OrderSearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ORDER)数据Mapper
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<OrderResultVO> searchOrder(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    List<Order> searchFieldTodayCondition(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
>>>>>>> fd1fe717dd5530926451dc4b0e91116c76f29c52
