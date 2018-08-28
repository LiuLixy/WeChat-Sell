package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * 商品类目表Service定义
 *
 * @Author: LiuWang
 * @Created: 2018/8/19 08:49
 */
public interface IProductCategoryService {
    Optional<ProductCategory> findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
