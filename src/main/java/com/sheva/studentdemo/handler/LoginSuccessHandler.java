package com.sheva.studentdemo.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
        if (roles.contains("ROLE_ADMIN")){
            response.sendRedirect(basePath + "adminlist");
            return;
        }else if (roles.contains("ROLE_USER")){
            response.sendRedirect(basePath + "list");
            return;
        }

        for (String role :
                roles) {
            System.out.println(role + "  ");
        }
        response.sendRedirect(basePath + "login");
    }
}
