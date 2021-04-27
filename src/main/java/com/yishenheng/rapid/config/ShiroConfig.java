//package com.yishenheng.rapid.config;
//
//import com.yishenheng.rapid.authentication.MyRealm;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author yishenheng
// * @date 2020-07-29 19:31
// */
//@Configuration
//public class ShiroConfig {
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        System.out.println("每次都会进来吗？");
//
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/doc.html/**", "anon");
//        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
//        filterChainDefinitionMap.put("/service-worker/**", "anon");
//        filterChainDefinitionMap.put("/webjars/js/**", "anon");
//        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/**", "authc");
//
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//
//
//        return shiroFilterFactoryBean;
//    }
//
//
//    @Bean
//    public SecurityManager securityManager() {
//        return new DefaultWebSecurityManager(myRealm());
//    }
//
//    @Bean
//    public MyRealm myRealm() {
//        return new MyRealm();
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//}
