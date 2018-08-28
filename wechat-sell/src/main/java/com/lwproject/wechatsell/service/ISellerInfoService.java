package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.SellerInfo;

/**
 * 卖家登录Service
 *
 * @author yuisama
 * @date 2018/8/23 12:23
 */
public interface ISellerInfoService {
    SellerInfo findByUserName(String username);
}
