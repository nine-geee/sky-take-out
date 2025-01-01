package com.sky.service;

import com.sky.dto.DishDTO;

//@Service
public interface DishService {

    /**
     * 新增菜品和口味数据
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
