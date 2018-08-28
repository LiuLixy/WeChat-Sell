package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.entity.ProductCategory;
import com.lwproject.wechatsell.dao.ProductCategoryDao;
import com.lwproject.wechatsell.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 商品类目表Service实现类
 *
 * @Author: LiuWang
 * @Created: 2018/8/19 14:26
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public Optional<ProductCategory> findOne(Integer categoryId) {
        return productCategoryDao.findById(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
