package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.ElementType;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        var d = new ElementType[]{ElementType.METHOD, ElementType.TYPE};
        SpringApplication.run(DemoApplication.class, args);
    }

}
