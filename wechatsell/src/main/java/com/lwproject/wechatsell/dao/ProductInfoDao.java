package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 16:08
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商品状态一次查询所有商品
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
