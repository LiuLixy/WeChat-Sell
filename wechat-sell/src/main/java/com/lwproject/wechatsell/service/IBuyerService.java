package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.dto.OrderDTO;

/**
 * 买家service
 *
 * @author yuisama
 * @date 2018/8/12
 */
public interface IBuyerService {
    OrderDTO findOneOrder(String openid, String orderId);

    OrderDTO cancleOrder(String openid, String orderId);
}
