package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.dao.OrderDetailDao;
import com.lwproject.wechatsell.dao.OrderMasterDao;
import com.lwproject.wechatsell.dto.CartDTO;
import com.lwproject.wechatsell.dto.OrderDTO;
import com.lwproject.wechatsell.entity.OrderDetail;
import com.lwproject.wechatsell.entity.OrderMaster;
import com.lwproject.wechatsell.entity.ProductInfo;
import com.lwproject.wechatsell.enums.ExceptionEnum;
import com.lwproject.wechatsell.exception.OrderException;
import com.lwproject.wechatsell.exception.ProductNotFoundException;
import com.lwproject.wechatsell.service.IOrderService;
import com.lwproject.wechatsell.service.IProductInfoService;
import com.lwproject.wechatsell.util.GenerateKeyUtil;
import com.lwproject.wechatsell.util.OrderMaster2OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:01
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        // 获取随机订单Id
        String orderId = GenerateKeyUtil.getUniqueKey();
        // 订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        // 1.从数据库查询商品的数量、价格
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            Optional<ProductInfo> productInfo =
                    productInfoService.findOne(orderDetail.getProductId());
            // 未找到指定商品
            if (productInfo == null) {
                throw new ProductNotFoundException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }
            // 2.计算订单总价
            orderAmount = productInfo.get().getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            // 订单详情入库
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(GenerateKeyUtil.getUniqueKey());
<<<<<<< HEAD:wechatsell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
            BeanUtils.copyProperties(productInfo.get(),orderDetail);
=======
            BeanUtils.copyProperties(productInfo.get(), orderDetail);
>>>>>>> 72f6a381900e2a10f37d1a662171c897d314a92c:wechat-sell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
            orderDetailDao.save(orderDetail);
        }
        // 3.写入订单数据库(OrderMaster、OrderDetail)
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);
        orderMasterDao.save(orderMaster);
        // 4.扣库存
        List<CartDTO> cartDTOList =
                orderDTO.getOrderDetailList().stream()
                        .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())
                        ).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        Optional<OrderMaster> orderMaster = orderMasterDao.findById(orderId);
        if (orderMaster == null) {
            throw new OrderException(ExceptionEnum.ORDER_NOT_EXISTS);
        }
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
<<<<<<< HEAD:wechatsell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        if (orderDetailList.size() ==0 ){
=======
        if (orderDetailList.size() == 0) {
>>>>>>> 72f6a381900e2a10f37d1a662171c897d314a92c:wechat-sell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
            throw new OrderException(ExceptionEnum.ORDER_DETAIL_NOT_EXISTS);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster.get(),orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findOrderList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage =
<<<<<<< HEAD:wechatsell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
                orderMasterDao.findByBuyerOpenid(buyerOpenid,pageable);
=======
                orderMasterDao.findByBuyerOpenid(buyerOpenid, pageable);
>>>>>>> 72f6a381900e2a10f37d1a662171c897d314a92c:wechat-sell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        // 将OrderMaster转为OrderDTO
        List<OrderDTO> orderDTOList =
                OrderMaster2OrderDTO.convert(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage =
                new PageImpl<>(orderDTOList,pageable,orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancelOrder(OrderDTO orderDTO) {
        // 1.查询订单状态，必须为新下订单才可取消。已完成订单不可取消
        OrderMaster orderMaster = new OrderMaster();
        if (!orderDTO.getOrderStatus().equals(0)) {
            log.error("【取消订单】订单状态不正确,orderId={},orderStatus={}",
                    orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new OrderException(ExceptionEnum.ORDER_STATUS_ERROR);
        }
        // 2.修改订单状态
        // 状态2表示已取消
        orderDTO.setOrderStatus(2);
<<<<<<< HEAD:wechatsell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        BeanUtils.copyProperties(orderDTO,orderMaster);
=======
        BeanUtils.copyProperties(orderDTO, orderMaster);
>>>>>>> 72f6a381900e2a10f37d1a662171c897d314a92c:wechat-sell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        OrderMaster result = orderMasterDao.save(orderMaster);
        if (result == null) {
            log.error("【取消订单】更新失败,orderMaster={}",orderMaster);
            throw new OrderException(ExceptionEnum.ORDER_UPDATE_FAIL);
        }
        // 3.返回库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【取消订单】订单中无商品详情,orderDTO={}",orderDTO);
            throw new OrderException(ExceptionEnum.ORDER_NO_DETAIL);
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.increaseStock(cartDTOList);
        // 4.已支付订单退款,支付状态1表示已支付
        if (orderDTO.getPayStatus().equals(1)) {
            //TODO
        }
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finishOrder(OrderDTO orderDTO) {
        // 1.判断订单状态，只有新下单状态的订单才可被接收。
        if(!orderDTO.getOrderStatus().equals(0)) {
            log.error("【完结订单】订单状态不正确,orderId={},orderStatus={}"
                    ,orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new OrderException(ExceptionEnum.ORDER_STATUS_ERROR);
        }
        // 2.修改订单状态,1表示商家已接单
        orderDTO.setOrderStatus(1);
        OrderMaster orderMaster = new OrderMaster();
<<<<<<< HEAD:wechatsell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        BeanUtils.copyProperties(orderDTO,orderMaster);
=======
        BeanUtils.copyProperties(orderDTO, orderMaster);
>>>>>>> 72f6a381900e2a10f37d1a662171c897d314a92c:wechat-sell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        OrderMaster result = orderMasterDao.save(orderMaster);
        if (result == null) {
            log.error("【完结订单】订单更新失败,orderMaster={}",orderMaster);
            throw new OrderException(ExceptionEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO payOrder(OrderDTO orderDTO) {
        // 1.判断订单状态,新订单才可支付
        if(!orderDTO.getPayStatus().equals(0)) {
            log.error("【支付订单】订单状态不正确,orderId={},PayStatus={}"
                    ,orderDTO.getOrderId(),orderDTO.getPayStatus());
            throw new OrderException(ExceptionEnum.ORDER_STATUS_ERROR);
        }
        // 2.判断支付状态,0表示未支付
        if (!orderDTO.getPayStatus().equals(0)){
            log.error("【支付订单】支付状态不正确,payStatus={}",orderDTO.getPayStatus());
            throw new OrderException(ExceptionEnum.ORDER_PAY_STATUS_ERROR);
        }
        // 3.修改支付状态,1表示已支付
        orderDTO.setPayStatus(1);
        OrderMaster orderMaster = new OrderMaster();
<<<<<<< HEAD:wechatsell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        BeanUtils.copyProperties(orderDTO,orderMaster);
=======
        BeanUtils.copyProperties(orderDTO, orderMaster);
>>>>>>> 72f6a381900e2a10f37d1a662171c897d314a92c:wechat-sell/src/main/java/com/lwproject/wechatsell/service/impl/OrderServiceImpl.java
        OrderMaster result = orderMasterDao.save(orderMaster);
        if (result == null) {
            log.error("【支付订单】订单更新失败,orderMaster={}",orderMaster);
            throw new OrderException(ExceptionEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage =
                orderMasterDao.findAll(pageable);
        List<OrderDTO> orderDTOList =
                OrderMaster2OrderDTO.convert(orderMasterPage.getContent());
        return new PageImpl<>(orderDTOList,pageable,orderMasterPage.getTotalElements());
    }
}
