package com.lwproject.wechatsell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 查询订单表单验证类
 *
 * @Author: LiuWang
 * @Created: 2018/8/26 14:56
 */
@Data
public class OrderListForm {
    @NotEmpty(message = "买家openid不能为空")
    private String openid;
    /**
     * 从第几页开始，默认为0
     */
    private Integer page = 0;
    /**
     * 每页展示数据量
     */
    private Integer size = 10;
}
