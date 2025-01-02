package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetMealDishMapper {

    /**
     * 根据菜品ID查询套餐
     * @param dishIds
     * @return
     */

    List<Long> getSetMealIdByDishId(List<Long> dishIds);
}
