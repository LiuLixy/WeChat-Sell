package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.dto.CartDTO;
import com.lwproject.wechatsell.entity.ProductInfo;
import com.lwproject.wechatsell.enums.ExceptionEnum;
import com.lwproject.wechatsell.enums.ProductStatusEnum;
import com.lwproject.wechatsell.exception.ProductNotFoundException;
import com.lwproject.wechatsell.exception.ProductStatusError;
import com.lwproject.wechatsell.exception.ProductStockErrorException;
import com.lwproject.wechatsell.repository.ProductInfoReposity;
import com.lwproject.wechatsell.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 13:29
 */
@Service
@Slf4j
public class ProductInfoServiceImpl implements IProductService {
    @Autowired
    private ProductInfoReposity reposity;
    @Override
    public Optional<ProductInfo> findOne(String productId) {
        Optional<ProductInfo> productInfo =
                reposity.findById(productId);
        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return reposity.findByProductStatus(0);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return reposity.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return reposity.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = reposity.findById(cartDTO.getProductId());
            if (productInfo == null) {
                throw new ProductNotFoundException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock()
                    + cartDTO.getProductQuantity();
            productInfo.get().setProductStock(result);
            reposity.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = reposity.findById(cartDTO.getProductId());
            if (productInfo == null) {
                throw new ProductNotFoundException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock()
                    - cartDTO.getProductQuantity();
            if (result < 0 ) {
                throw new ProductStockErrorException(ExceptionEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.get().setProductStock(result);

            reposity.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public ProductInfo onSale(String productId) {
        Optional<ProductInfo> productInfo = reposity.findById(productId);
        if (productInfo == null) {
            throw new ProductNotFoundException(ExceptionEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.get().getProductStatus() == ProductStatusEnum.UP.getCode()){
            log.error("商品已为上架状态，无须再次上架..");
            throw new ProductStatusError(ExceptionEnum.PRODUCT_STATUS_ERROR);
        }
        log.info("商品上架ing..，商品Id为{}",productId);
        productInfo.get().setProductStatus(ProductStatusEnum.UP.getCode());
        return reposity.save(productInfo.get());
    }

    @Override
    @Transactional
    public ProductInfo offSale(String productId) {
        Optional<ProductInfo> productInfo = reposity.findById(productId);
        if (productInfo == null) {
            throw new ProductNotFoundException(ExceptionEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.get().getProductStatus() == ProductStatusEnum.DOWN.getCode()){
            log.error("商品已为下架状态，无须再次下架..");
            throw new ProductStatusError(ExceptionEnum.PRODUCT_STATUS_ERROR);
        }
        log.info("商品下架中..，商品Id为{}",productId);
        productInfo.get().setProductStatus(ProductStatusEnum.DOWN.getCode());
        return reposity.save(productInfo.get());
    }

}
