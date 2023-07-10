package com.screen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class MaxStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaxStudioApplication.class, args);
        log.info("Serve Started");
    }

}
