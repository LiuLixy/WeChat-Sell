package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.service.ISellerInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuisama
 * @date 2018/8/23 12:26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoServiceImplTest {
    @Autowired
    private ISellerInfoService sellerInfoService;
    @Test
    public void findSellerInfoByOpenId() {

    }
}