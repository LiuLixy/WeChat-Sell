package com.lwproject.wechatsell.controller;

import com.lwproject.wechatsell.vo.ResultVO;
import com.lwproject.wechatsell.dto.OrderDTO;
import com.lwproject.wechatsell.enums.ExceptionEnum;
import com.lwproject.wechatsell.exception.OrderException;
import com.lwproject.wechatsell.form.OrderDetailForm;
import com.lwproject.wechatsell.form.OrderForm;
import com.lwproject.wechatsell.form.OrderListForm;
import com.lwproject.wechatsell.service.IBuyerService;
import com.lwproject.wechatsell.service.IOrderService;
import com.lwproject.wechatsell.util.OrderForm2OrderDTO;
import com.lwproject.wechatsell.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:47
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBuyerService buyerService;
    /**
     * 创建订单Controller
     * @param orderForm 表单入参校验
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult) {
        // 创建订单入参有误
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm={}",orderForm);
            throw new OrderException(ExceptionEnum.ORDER_FORM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // 将OrderForm转为OrderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new OrderException(ExceptionEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }

    /**
     * 查询订单列表Controller
     * @param orderListForm 表单入参校验
     * @param bindingResult
     * @return
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@Valid OrderListForm orderListForm,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【查询订单列表】失败，openid为空");
            throw new OrderException(ExceptionEnum.ORDER_FORM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        PageRequest request = PageRequest.of(orderListForm.getPage(),orderListForm.getSize());
        Page<OrderDTO> orderDTOPage = orderService.findOrderList(
                orderListForm.getOpenid(),request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    /**
     * 查询订单详情controller
     * @param orderDetailForm 订单详情表单校验
     * @param bindingResult
     * @return
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@Valid OrderDetailForm orderDetailForm,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【查询订单详情】失败，参数不正确,orderDetailForm={}",orderDetailForm);
            throw new OrderException(ExceptionEnum.ORDER_FORM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO result = buyerService.findOneOrder(orderDetailForm.getOpenid(),
                orderDetailForm.getOrderId());
        return ResultVOUtil.success(result);
    }

    /**
     * 取消订单controller
     * @param orderDetailForm
     * @param bindingResult
     * @return
     */
    @GetMapping("/cancle")
    public ResultVO<OrderDTO> cancle(@Valid OrderDetailForm orderDetailForm,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【取消订单】失败，参数不正确,orderDetailForm={}",orderDetailForm);
            throw new OrderException(ExceptionEnum.ORDER_FORM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO result = buyerService.cancelOrder(orderDetailForm.getOpenid(),
                orderDetailForm.getOrderId());
        return ResultVOUtil.success(result);
    }
}
