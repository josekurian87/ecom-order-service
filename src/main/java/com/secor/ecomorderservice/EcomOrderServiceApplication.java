package com.secor.ecomorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class EcomOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomOrderServiceApplication.class, args);
    }

}
