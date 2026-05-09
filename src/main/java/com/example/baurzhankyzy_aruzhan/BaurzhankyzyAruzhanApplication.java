package com.example.baurzhankyzy_aruzhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BaurzhankyzyAruzhanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaurzhankyzyAruzhanApplication.class, args);
    }

}
