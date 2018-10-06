package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 15:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class IProductCategoryServiceTest {

    @Autowired
    private IProductCategoryService productCategoryService;

    @Test
    public void findOne() {
        Optional<ProductCategory> productCategory
                = productCategoryService.findOne(1);
        Assert.assertNotNull(productCategory.get());
    }

    @Test
    public void findCategoryById() {
        Optional<ProductCategory> result = productCategoryService.findCategoryById(1);

    }

    @Test
    public void productCategoryList() {
    }

    @Test
    public void findAll() {
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我的最爱");
        productCategory.setCategoryType(2);
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}