package com.example.demo.interceptor;

import com.example.demo.annotation.Allow;
import com.example.demo.service.PermissionService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    final PermissionService permissionService;

    public PermissionInterceptor(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        var handle = (HandlerMethod) handler;
        var controller = handle.getBean().getClass();

        if (controller.isAnnotationPresent(Allow.class)) {
            return true;
        }

        var method = handle.getMethod();
        if (method.isAnnotationPresent(Allow.class)) {
            return true;
        }

        if (permissionService.CheckExistByUri(request.getRequestURI())) {
            return true;
        }

        response.setStatus(403);
        response.setContentType("application/json");
        response.getWriter().println("{'message':'you don't have permission!'}");
        response.getWriter().flush();
        response.getWriter().close();
        return false;
    }

}
