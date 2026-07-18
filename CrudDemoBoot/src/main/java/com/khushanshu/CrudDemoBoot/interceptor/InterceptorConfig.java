package com.khushanshu.CrudDemoBoot.interceptor;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final RequestResponseLoggingInterceptor requestResponseLoggingInterceptor;

    private final RoleBasedAuthorizationInterceptor roleBasedAuthorizationInterceptor;

    @Autowired
    InterceptorConfig(RequestResponseLoggingInterceptor requestResponseLoggingInterceptor, RoleBasedAuthorizationInterceptor roleBasedAuthorizationInterceptor){
        this.requestResponseLoggingInterceptor=requestResponseLoggingInterceptor;
        this.roleBasedAuthorizationInterceptor=roleBasedAuthorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestResponseLoggingInterceptor)
                .order(2);

        registry.addInterceptor(roleBasedAuthorizationInterceptor)
                .order(1)
                .includeHttpMethods(HttpMethod.DELETE)
                .addPathPatterns("/api/students");


    }
}
