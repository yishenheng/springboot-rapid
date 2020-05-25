package com.yishenheng.rapid.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yishenheng
 * @date 2020-05-25 12:28
 */
@Getter
@AllArgsConstructor
public enum ResultCode {


    /**
     * 操作失败返回
     */
    FAIL(-1, "FAIL"),

    /**
     * 操作成功返回
     */
    SUCCESS(200, "SUCCESS"),

    ;

    private final int code;
    private final String message;
}
