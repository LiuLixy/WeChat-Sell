package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.SellerInfo;

/**
 * 卖家登录Service
 *
 * @Author: LiuWang
 * @Created: 2018/8/19 11:27
 */
public interface ISellerInfoService {
    SellerInfo findByUserName(String username);
}
