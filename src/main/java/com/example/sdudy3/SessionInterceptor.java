package com.example.sdudy3;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().equals("user/loginView")||request.getRequestURI().equals("user/indexView")){
            return true;
        }
        Object obj = request.getSession().getAttribute("_session_user");
        if(obj==null){
            response.sendRedirect("/user/loginView");
            return false;
        }
        return true;
    }
}
