package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuisama
 * @date 2018/8/3 13:05
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
