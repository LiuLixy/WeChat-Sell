package com.lwproject.wechatsell.repository;

import com.lwproject.wechatsell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:32
 */
public interface SellerInfoReposity extends JpaRepository<SellerInfo,String> {
    /**
     * 通过用户名查找
     *
     * @param username
     * @return
     */
    SellerInfo findByUsername(String username);
}
