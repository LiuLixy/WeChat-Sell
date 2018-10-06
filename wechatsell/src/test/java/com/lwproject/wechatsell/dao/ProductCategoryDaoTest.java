package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 15:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("aaa");
        productCategory.setCategoryType(1);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryList = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> productCategoryList = productCategoryDao.findByCategoryTypeIn(categoryList);
        Assert.assertEquals(1, productCategoryList.size());
    }


}