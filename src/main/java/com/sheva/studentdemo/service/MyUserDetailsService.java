package com.sheva.studentdemo.service;

import com.sheva.studentdemo.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        if (username.equals("admin") ){
            UserInfo userInfo = new UserInfo(username, "admin", "ROLE_ADMIN",
                    true, true, true, true);
            return userInfo;
        }else if (username.equals("sheva")){
            UserInfo userInfo = new UserInfo(username, "sheva", "ROLE_USER",
                    true, true, true, true);
            return userInfo;
        }
        return null;
    }
}
