package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 15:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("123457");
        orderDetail.setProductName("豆腐脑");
        orderDetail.setProductPrice(new BigDecimal(3.5));
        orderDetail.setProductQuantity(100);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() {
    }
}