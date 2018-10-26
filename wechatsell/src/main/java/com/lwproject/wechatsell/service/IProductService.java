package com.lwproject.wechatsell.service;

import com.lwproject.wechatsell.dto.CartDTO;
import com.lwproject.wechatsell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 16:26
 */
public interface IProductService {

    /**
     * 根据商品 id 查询商品
     *
     * @param productId
     * @return
     */
    Optional<ProductInfo> findOne(String productId);

    /**
     * 查询所有上架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询
     *
     * @param pageable 分页参数
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品信息
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 增加库存
     *
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减少库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 在售商品
     *
     * @param productId
     * @return
     */
    ProductInfo onSale(String productId);

    /**
     * 下架商品
     *
     * @param productId
     * @return
     */
    ProductInfo offSale(String productId);
}
