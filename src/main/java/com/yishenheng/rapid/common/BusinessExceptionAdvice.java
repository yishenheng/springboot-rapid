package com.yishenheng.rapid.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.SignatureException;

/**
 * @author   yishenheng
 * @date 2020-05-25 12:49
 */
@ControllerAdvice
public class BusinessExceptionAdvice {

    /**
     * 全局拦截器
     *
     * @param ex 指定异常
     * @return 修改返回值
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultData errorHandler(Exception ex) {
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            return new ResultData(be.getCode(), be.getMessage());
        }
        ex.printStackTrace();
        return new ResultData(ResultCode.FAIL.getCode(), ex.getMessage());
    }

    @ExceptionHandler(SignatureException.class)
    @ResponseBody
    public ResultData authorizationException(SignatureException e) {
        return new ResultData(ResultCode.FAIL.getCode(), e.getMessage());
    }
}
