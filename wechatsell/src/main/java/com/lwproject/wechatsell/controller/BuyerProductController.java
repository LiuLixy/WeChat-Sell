package com.lwproject.wechatsell.controller;

import com.lwproject.wechatsell.vo.ProductInfoVO;
import com.lwproject.wechatsell.vo.ProductVO;
import com.lwproject.wechatsell.vo.ResultVO;
import com.lwproject.wechatsell.entity.ProductCategory;
import com.lwproject.wechatsell.entity.ProductInfo;
import com.lwproject.wechatsell.service.IProductCategoryService;
import com.lwproject.wechatsell.service.IProductService;
import com.lwproject.wechatsell.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品控制层
 *
 * @Author: LiuWang
 * @Created: 2018/8/25 16:44
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductCategoryService productCategoryService;
    @GetMapping("/list")
    public ResultVO list() {
        //1. 查询所有上架的商品
        List<ProductInfo> productInfoLists = productService.findUpAll();

        //2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
//        // 传统方法
//        for (ProductInfo productInfo: productInfoLists) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
//        productCategoryService.findByCategoryTypeIn(categoryTypeList);
       // 精简做法
        List<Integer> categoryList =
                productInfoLists.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList =
                productCategoryService.findByCategoryTypeIn(categoryList);
        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfoLists) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOLists(productInfoVOS);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
