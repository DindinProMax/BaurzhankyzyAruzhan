package com.example.baurzhankyzy_aruzhan.AruzhanConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaurzhankyzyAruzhanSwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("University Management System API by Baurzhankyzy Aruzhan")
                        .version("1.0")
                        .description("Final project backend documentation"));
    }
}