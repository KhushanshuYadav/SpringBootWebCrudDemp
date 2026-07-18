package com.khushanshu.CrudDemoBoot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RoleBasedAuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       String role =request.getHeader("role");

       if(role!=null && !role.equals("Admin")){
           response.setStatus(HttpServletResponse.SC_FORBIDDEN);
           response.setContentType("\"application/json\"");
           response.getWriter().write("""
                   {
                   "message" : "You are not Authorized to perform this action"
                   }
                   """);

           return false;
       }
       return true;
    }

}
