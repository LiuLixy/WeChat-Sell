package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.dto.OrderDTO;

/**
 * 买家service
 *
 * @Author: LiuWang
 * @Created: 2018/8/19 07:46
 */
public interface IBuyerService {
    OrderDTO findOneOrder(String openid, String orderId);

    OrderDTO cancleOrder(String openid, String orderId);
}
