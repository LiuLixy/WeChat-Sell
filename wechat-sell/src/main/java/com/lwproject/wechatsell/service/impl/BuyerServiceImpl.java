package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.dto.OrderDTO;
import com.lwproject.wechatsell.enums.ExceptionEnum;
import com.lwproject.wechatsell.exception.OrderException;
import com.lwproject.wechatsell.service.IBuyerService;
import com.lwproject.wechatsell.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:27
 */
@Service
@Slf4j
public class BuyerServiceImpl implements IBuyerService {
    @Autowired
    private IOrderService orderService;

    @Override
    public OrderDTO findOneOrder(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单,orderId={},openid={}"
                    , orderId, openid);
            throw new OrderException(ExceptionEnum.ORDER_NOT_EXISTS);
        }
        return orderService.cancelOrder(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        // 查询者与创建订单者不一致
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】错误，订单openid与查询者不一致!openid={},orderDTO={}"
                    , openid, orderDTO);
            throw new OrderException(ExceptionEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
