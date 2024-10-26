package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/api/login","/index.html","/api/visitor","/api/example","/api/example/**").permitAll()  // 允许匿名访问登录相关路径
                        .requestMatchers("/api/logout").permitAll()
                        .requestMatchers("/api/user").hasRole("USER")
                        .requestMatchers("/api/admin").hasRole("users")
                        .anyRequest().authenticated()  // 其他请求需要认证
                )
                .formLogin(form -> form
                        .loginPage("/index.html")  // 自定义登录页面
                        .permitAll()  // 允许所有用户访问登录页面
                )
                .logout(LogoutConfigurer::permitAll  // 允许所有用户访问登出
                )
                .csrf(AbstractHttpConfigurer::disable);  // 禁用 CSRF
        return http.build();
    }
}
