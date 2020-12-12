package com.example.demo.service.impl;

import com.example.demo.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    final List<String> array;

    public PermissionServiceImpl() {
        array = new ArrayList<>();
        array.add("/index");
        array.add("/user");
    }

    @Override
    public boolean CheckExistByUri(String uri) {
        return array.indexOf(uri) > 0;
    }
}
