package com.lwproject.wechatsell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: LiuWang
 * @Created: 2018/8/20 09:26
 */
@Data
public class OrderDetailForm {
    @NotEmpty(message = "用户openid不能为空")
    private String openid;
    @NotEmpty(message = "用户订单Id不能为空")
    private String orderId;
}
