package com.yishenheng.rapid.constant;

/**
 * @author yishenheng
 * @date 2020-07-07 14:19
 */
public interface RedisConstant {

    /**
     * 用户信息缓存
     */
    String USER_INFO_CACHE_PREFIX = "rapid.cache.user.";

    /**
     * 用户token
     */
    String USER_JWT_CACHE_PREFIX = "rapid.cache.token.";
}
