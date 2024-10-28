package com.example.demo.security;

import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/index.html", "/login.html").permitAll()
                        .requestMatchers("/login", "/api/login").permitAll()
                        .requestMatchers("/manage.html","/api/oaaaT/**","/api/oaaaF/**","api/data/activeOAAA").hasRole("ADMIN")
                        .requestMatchers("/DA.html","/api/gaT/**","/api/gaF/**","api/data/activeGA").hasRole("USER")
                        .anyRequest().authenticated() //
                )
                .formLogin(form -> form
                        .loginPage("/login.html")  // 指定登录页面
                        .successHandler(customAuthenticationSuccessHandler)  // 使用自定义的成功处理器
                        .permitAll() // 允许所有用户访问登录页面
                )
                .logout(LogoutConfigurer::permitAll) // 允许所有用户退出登录
                .csrf(AbstractHttpConfigurer::disable) // 禁用CSRF保护
                .authenticationManager(authenticationManager); // 设置自定义的AuthenticationManager
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
