package com.zzyy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 *
 * 判断登陆用户是否具有角色权限
 */

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : collection) {
          String needRole =  configAttribute.getAttribute();
          //如果需要登录后才能访问
          if("ROLE_LOGIN".equals(needRole)){
              //如果未登陆
              if(authentication instanceof AnonymousAuthenticationToken){
                   throw new AccessDeniedException("尚未登陆，请登陆");
              }else
                  return ;

          }
          //获取当前登陆用户的角色
         Collection<? extends GrantedAuthority> auth =authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : auth) {
                //如果具备角色
                if(grantedAuthority.getAuthority().equals(needRole))
                    return;
            }

        }
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
