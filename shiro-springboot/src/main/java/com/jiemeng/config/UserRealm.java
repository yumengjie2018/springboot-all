package com.jiemeng.config;

import com.jiemeng.pojo.User;
import com.jiemeng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService service;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前对应的对象
        Subject subject = SecurityUtils.getSubject();
        //权限可以通过从数据库读取，User对象从认证中传，拿到user对象
        User user=(User) subject.getPrincipal();
        info.addStringPermission(user.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        //用户名密码,数据库中取
        UsernamePasswordToken userToken=(UsernamePasswordToken)token;
        User user=service.queryUserByName(userToken.getUsername());
        if(user==null){
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser",user);
        //密码认证 shiro做
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
