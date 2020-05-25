package com.yishenheng.rapid.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yishenheng
 * @date 2020-05-25 12:22
 * 统一API相应结果
 */
@Getter
@Setter
@ApiModel(value = "ResultData", description = "统一API相应结果")
public class ResultData<T> {


    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "描述信息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    ResultData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
