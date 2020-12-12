package com.example.demo.configs;

import com.example.demo.interceptor.JwtInterceptor;
import com.example.demo.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    final PermissionInterceptor permissionInterceptor;
    final JwtInterceptor jwtInterceptor;

    public InterceptorConfiguration(PermissionInterceptor permissionInterceptor, JwtInterceptor jwtInterceptor) {
        this.permissionInterceptor = permissionInterceptor;
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(permissionInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**");
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
//                .allowedOriginPatterns("*")
//                .maxAge(3600 * 24);
//    }
}
