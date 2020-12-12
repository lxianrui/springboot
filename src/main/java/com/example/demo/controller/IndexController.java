package com.example.demo.controller;

import com.example.demo.annotation.Allow;
import com.example.demo.configs.Audience;
import com.example.demo.utils.TokenUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequestMapping(value = "/")
@RestController
public class IndexController {

    final Audience audience;

    public IndexController(Audience audience) {
        this.audience = audience;
    }

    @Allow(name = "123")
    @GetMapping("index")
    public String index() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("user")
    public String user() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("role")
    public String role() {
        return UUID.randomUUID().toString();
    }

    @Allow
    @GetMapping("login")
    public String login() throws Exception {
        String token = TokenUtil.createJWT("123");
        return token;
    }
}
