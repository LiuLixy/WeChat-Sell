package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.dto.OrderDTO;

/**
 * 买家service
 *
 * @Author: LiuWang
 * @Created: 2018/8/26 13:25
 */
public interface IBuyerService {
    /**
     * 根据买家微信 openid 和 订单 id 查询订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOneOrder(String openid,String orderId);
    /**
     * 根据买家微信 openid 和 订单 id 订单取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
