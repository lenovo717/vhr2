package com.zzyy.vhr.config;

import com.zzyy.vhr.model.Menu;
import com.zzyy.vhr.model.Role;
import com.zzyy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/*
* 根据用户传来的请求地址，分析出请求需要的角色
* */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    //路径对比工具
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
       //获取请求地址
       String requestUrl =  ((FilterInvocation)o) .getRequestUrl();
       List<Menu> menuList =  menuService.getAllMenusWithRole();
        for (Menu menu : menuList) {
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                 String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                //获取请求url所需要的角色
                return SecurityConfig.createList(str);
            }
        }
        //没匹配上 标记为登陆后再访问
       return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
