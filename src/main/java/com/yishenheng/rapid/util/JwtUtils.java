//package com.yishenheng.rapid.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.Date;
//
///**
// * @author yishenheng
// * @date 2020-07-12 22:03
// */
//@Slf4j
//public class JwtUtils {
//
//    /**
//     * 生成token，直接使用用户密码作为盐
//     *
//     * @param userName 用户名称
//     * @param sign     用户密码
//     * @return token
//     */
//    public static String createToken(String userName, String sign) {
//        try {
//            userName = StringUtils.lowerCase(userName);
//            // 设置过期时间
//            Date date = new Date(System.currentTimeMillis() + 60 * 10 * 1000);
//            return JWT.create().withClaim("userName", userName).withExpiresAt(date).sign(Algorithm.HMAC256(sign));
//        } catch (Exception e) {
//            log.error("createToken is error msg:{}", e.getMessage());
//            return null;
//        }
//    }
//
//    /**
//     * 根据token获取用户名
//     *
//     * @param token token
//     * @return 用户名
//     */
//    public static String getUserNameByToken(String token) {
//        try {
//            return JWT.decode(token).getClaim("userName").asString();
//        } catch (Exception e) {
//            log.error("getUserName error msg:{}", e.getMessage());
//            return null;
//        }
//    }
//
//
//    /**
//     * 校验token是否正确
//     *
//     * @param token    token
//     * @param userName 用户名
//     * @param secret   密码
//     * @return true:正确 false:错误
//     */
//    public static boolean checkToken(String token, String userName, String secret) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withClaim("userName", userName)
//                    .build();
//            verifier.verify(token);
//        } catch (Exception e) {
//            log.error("checkToken error msg:{}", e.getMessage());
//            return false;
//        }
//        return true;
//    }
//}
