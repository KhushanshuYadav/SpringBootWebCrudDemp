package com.khushanshu.CrudDemoBoot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestResponseLoggingInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Logging Request");
        System.out.println(request.getHeaders("X-Request-ID"));
        System.out.println(request.getRequestURI());
        System.out.println(request.getParameterMap());
        System.out.println(request.getMethod());
        if(handler instanceof HandlerMethod handlerMethod){
            System.out.println(handlerMethod.getMethod().getName());
            System.out.println(handlerMethod.getBeanType().getName());
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("Logging Response");
        System.out.println(response.getStatus());
    }
}
