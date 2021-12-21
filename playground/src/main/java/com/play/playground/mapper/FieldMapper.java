package com.play.playground.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.play.playground.entity.Field;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.play.playground.vo.FieldSearchResultVO;
import com.play.playground.vo.FieldSearchVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * (FIELD)数据Mapper
 *
 * @author kancy
 * @since 2021-12-18 14:49:07
 * @description 由 Mybatisplus Code Generator 创建
*/
@Mapper
public interface FieldMapper extends BaseMapper<Field> {

    IPage<FieldSearchResultVO> searchField(QueryWrapper queryWrapper, Page page);

}
