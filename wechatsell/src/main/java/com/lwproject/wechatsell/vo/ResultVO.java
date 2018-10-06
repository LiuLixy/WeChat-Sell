package com.lwproject.wechatsell.vo;

import lombok.Data;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 10:22
 */
@Data
public class ResultVO<T> {

    /**
     * 错误提示码
     */
    private Integer code;

    /**
     * 错误提示信息
     */
    private String msg;

    /**
     * 返回具体内容
     */
    private T data;
}
