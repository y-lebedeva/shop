package com.epam.javard.shop.web.interceptor;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {

        User user = userManager.getCurrentUser();

        if (user != null && user.getId() != null) {
            request.setAttribute("user", user);
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
