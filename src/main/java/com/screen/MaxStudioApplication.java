package com.screen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.screen.mapper")
@SpringBootApplication
public class MaxStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaxStudioApplication.class, args);
    }

}
