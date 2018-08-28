package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * 商品类目表Service定义
 *
 * @author yuisama
 * @date 2018/8/3 15:13
 */
public interface IProductCategoryService {
    Optional<ProductCategory> findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
