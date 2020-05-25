package com.yishenheng.rapid.common;

/**
 * @author yishenheng
 * @date 2020-05-25 12:26
 */
public class BaseController {

    public <T> ResultData<T> ok() {
        return ok(null);
    }

    public <T> ResultData<T> ok(T data) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public <T> ResultData<T> fail(String msg) {
        return new ResultData<>(ResultCode.FAIL.getCode(), msg);
    }

    public <T> ResultData<T> fail(ResultCode resultCode) {
        return new ResultData<>(resultCode.getCode(), resultCode.getMessage());
    }

}
