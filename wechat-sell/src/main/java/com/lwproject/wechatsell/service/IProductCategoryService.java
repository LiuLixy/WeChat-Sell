package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * 商品类目表Service定义
 *
 * @Author: LiuWang
 * @Created: 2018/8/25 14:39
 */
public interface IProductCategoryService {
    /**
     * 通过 id 查询
     *
     * @param categoryId
     * @return
     */
    Optional<ProductCategory> findOne(Integer categoryId);

    /**
     * 一次性查询所有类目
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据传入的类目 type 一次性查询多个类目
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存/更新类目
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
