package com.lwproject.wechatsell.repository;

import com.lwproject.wechatsell.entity.SellerInfo;
import com.lwproject.wechatsell.util.GenerateKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuisama
 * @date 2018/8/23 12:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoReposityTest {
    @Autowired
    private SellerInfoReposity sellerInfoReposity;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(GenerateKeyUtil.getUniqueKey());
        sellerInfo.setUsername("yuisama");
        sellerInfo.setPassword("123456");
        sellerInfoReposity.save(sellerInfo);
    }


}