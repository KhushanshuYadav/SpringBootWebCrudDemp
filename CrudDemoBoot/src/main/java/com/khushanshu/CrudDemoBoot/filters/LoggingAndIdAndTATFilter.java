package com.khushanshu.CrudDemoBoot.filters;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@WebFilter("/api")
@Order(2)
public class LoggingAndIdAndTATFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

        long startTime = System.currentTimeMillis();

        String requestId=UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-Request-ID" ,requestId);

        System.out.println("Incoming Request : " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());

        try{
            chain.doFilter(request,response);
        }finally {

            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Response status: " +  httpServletResponse.getStatus());
            System.out.println("API Response time : " + duration);

        }
    }
}
