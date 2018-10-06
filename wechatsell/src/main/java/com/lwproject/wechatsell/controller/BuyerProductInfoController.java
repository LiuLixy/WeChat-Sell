package com.lwproject.wechatsell.controller;

import com.lwproject.wechatsell.entity.ProductCategory;
import com.lwproject.wechatsell.entity.ProductInfo;
import com.lwproject.wechatsell.service.IProductCategoryService;
import com.lwproject.wechatsell.service.IProductInfoService;
import com.lwproject.wechatsell.util.ResultVOUtil;
import com.lwproject.wechatsell.vo.ProductInfoVO;
import com.lwproject.wechatsell.vo.ProductVO;
import com.lwproject.wechatsell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 16:44
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductInfoController {

    @Autowired
    private IProductInfoService productInfoService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查找所有的在架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 2. 根据在架商品查找出所有类目Type
        // 原始做法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductCategory productCategory : findByCategoryTypeIn) {
//            categoryTypeList.add(productCategory.getCategoryType());
//        }
        // JDK 1.8
        List<Integer> categoryTypeList =
                productInfoList.stream()
                        .map(e -> e.getCategoryType())
                        .collect(Collectors.toList());

        // 3. 根据 type 查找所有 ProductCategory
        List<ProductCategory> productCategoryList =
                productCategoryService.findByCategoryTypeIn(categoryTypeList);

        // 4. 数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOLists(productInfoVOS);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}
