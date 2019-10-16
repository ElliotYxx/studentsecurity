package com.sheva.studentdemo.provider;

import com.sheva.studentdemo.entity.UserInfo;
import com.sheva.studentdemo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();//表单中返回的用户名
        String password = authentication.getPrincipal().toString();//表单中输入的密码

        System.out.println(userName + "   " + password);

        UserInfo userInfo = (UserInfo) myUserDetailsService.loadUserByUsername(userName);

        if (!userInfo.getPassword().equals(password)){
            throw new BadCredentialsException("密码错误！");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        //构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
