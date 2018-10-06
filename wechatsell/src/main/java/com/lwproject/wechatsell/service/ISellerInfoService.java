package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.entity.SellerInfo;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 13:28
 */
public interface ISellerInfoService {

    /**
     * 通过用户名查找卖家信息
     *
     * @param username
     * @return
     */
    SellerInfo findByUserName(String username);

}
