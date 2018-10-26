package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/20 18:37
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    /**
     * 根据商品类型查找
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
