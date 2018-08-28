package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 08:32
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
