package com.example.baurzhankyzy_aruzhan.AruzhanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BaurzhankyzyAruzhanSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Отключаем для REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Вход и регистрация открыты
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Документация открыта
                        .anyRequest().authenticated() // Все остальное требует логина
                );
        return http.build();
    }
}
