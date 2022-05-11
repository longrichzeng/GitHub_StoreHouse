package com.example.anime.temporyPackage.Realm;

import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import com.example.anime.Service.userLoginInformationService.UserLoginInformationService;
import com.example.anime.temporyPackage.Util.ApplicationContextUtil;
import com.example.anime.temporyPackage.Util.CustomerByteSourceUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 自定义Realm
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserLoginInformationService userLoginInformationService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
////        获取主身份信息
//        String principal = (String) principals.getPrimaryPrincipal();
////        根据主身份信息获取角色信息
//        UserLoginInformationService userLoginInformationService = (UserLoginInformationService) ApplicationContextUtil.getBean("userLoginInformationService");
//        UserLoginInformationEntity user = (UserLoginInformationEntity) userLoginInformationService.getUserInfor(principal);
//
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        return null;

    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String principal = (String) token.getPrincipal();
        // 由于CustomerRealm并没有交由工厂管理，故不能诸如UserLoginInformationService
        UserLoginInformationService userLoginInformationService = (UserLoginInformationService) ApplicationContextUtil.getBean("userLoginInformationService");
        UserLoginInformationEntity user =  userLoginInformationService.getUserInfor(principal);

        System.out.println("从数据库拿出来的加密密码：\t" + user.getPassword());
        System.out.println("从数据库拿出来的盐1：\t" + ByteSource.Util.bytes(user.getSalt()));
        System.out.println("从数据库拿出来的盐3：\t" + user.getSalt());

        if(!ObjectUtils.isEmpty(user)){
            String username = user.getUsername();
            String password = user.getPassword();
            ByteSource salt = new CustomerByteSourceUtil(user.getSalt());
            return new SimpleAuthenticationInfo(username, password, salt, this.getName());
        }
        return null;
    }
}
















