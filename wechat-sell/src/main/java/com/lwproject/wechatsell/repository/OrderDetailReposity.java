package com.lwproject.wechatsell.repository;

import com.lwproject.wechatsell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 10:31
 */
public interface OrderDetailReposity extends JpaRepository<OrderDetail,String> {

    /**
     * 通过订单 id 查询订单详情表
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
