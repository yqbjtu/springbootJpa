package com.yq.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JpaDemoApplication {
    private static final Logger log = LoggerFactory.getLogger(JpaDemoApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(JpaDemoApplication.class, args);
        log.info("Spring Boot start done!");
    }

}
