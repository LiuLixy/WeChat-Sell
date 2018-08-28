package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 10:12
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
