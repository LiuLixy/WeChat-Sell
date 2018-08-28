package com.lwproject.wechatsell.util;

import com.lwproject.wechatsell.vo.ResultVO;

/**
 * @author yuisama
 * @date 2018/8/6 17:45
 */
public class ResultVOUtil {
    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
