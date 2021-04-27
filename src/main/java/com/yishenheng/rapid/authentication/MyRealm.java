//package com.yishenheng.rapid.authentication;
//
//import com.yishenheng.rapid.common.BusinessException;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
///**
// * @author yishenheng
// * @date 2020-07-13 16:02
// */
//
//public class MyRealm extends AuthorizingRealm {
//
//    /**
//     * 授权
//     *
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println(principalCollection.getPrimaryPrincipal());
//        System.out.println(principalCollection.getRealmNames());
//        return null;
//    }
//
//    /**
//     * 认证
//     *
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println(authenticationToken.getPrincipal());
//        System.out.println(authenticationToken.getCredentials());
//        return null;
//    }
//}
