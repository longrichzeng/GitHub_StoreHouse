package com.example.anime.temporyPackage.Config;

import com.example.anime.temporyPackage.Constants.ShiroConstant;
import com.example.anime.temporyPackage.Realm.ShiroRealm;
import com.example.anime.temporyPackage.Redis.RedisCacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Shiro的核心配置类，用来整合shiro框架
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建shiroFilter，负责拦截所有请求
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统资源
        Map<String, String> map = new HashMap<String, String>();
//        map.put("/login/*", "authc");
//        map.put("/administrator/*", "authc");
//        map.put("/ShoppingCart/*", "authc");
//        map.put("/individual/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建安全管理器
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    /**
     * 创建自定义Realm
     */
    @Bean
    public Realm getRealm(){
        ShiroRealm customerRealm = new ShiroRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();// 设置密码匹配器
        credentialsMatcher.setHashAlgorithmName(ShiroConstant.HASH_ALGORITHM_NAME.MD5);// 设置加密方式
        credentialsMatcher.setHashIterations(ShiroConstant.HASH_ITERATORS);// 设置散列次数
        customerRealm.setCredentialsMatcher(credentialsMatcher);

        // 开启认证缓存并指定缓存名称
        customerRealm.setCacheManager(new RedisCacheManager());
        // 开启全局缓存
        customerRealm.setCachingEnabled(true);
        // 开启认证缓存并指定缓存名称
        customerRealm.setAuthenticationCachingEnabled(true);
        customerRealm.setAuthenticationCacheName("authenticationCache");
        // 开启授权缓存并指定缓存名称
        customerRealm.setAuthorizationCachingEnabled(true);
        customerRealm.setAuthorizationCacheName("authorizationCache");
        return customerRealm;
    }

}


























