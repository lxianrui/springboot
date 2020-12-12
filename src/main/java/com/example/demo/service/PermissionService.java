package com.example.demo.service;

import org.springframework.stereotype.Service;


public interface PermissionService {
    boolean CheckExistByUri(String uri);
}
