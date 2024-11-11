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
                .cors(cors -> cors.configurationSource(request -> {
                    org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
                    config.setAllowCredentials(true);
                    config.addAllowedOriginPattern("*"); // 允许所有域
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");
                    return config;
                }))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("User.html", "/login.html","index.html").permitAll()
                        .requestMatchers("/login", "/api/login", "/api/GetAd", "/api/visitor","/api/data/User").permitAll()
                        .requestMatchers("/api/oaaaT/**", "/api/oaaaF/**", "/api/data/InforC").hasRole("INFORC")
                        .requestMatchers("/api/gaT/**", "/api/gaF/**", "/api/data/Concierge").hasRole("CONCIERGE")
                        .requestMatchers("/api/oaaaT/**", "/api/oaaaF/**", "/api/data/HumanC").hasRole("HUMANC")
                        .requestMatchers("/api/oaaaT/**", "/api/oaaaF/**", "/api/data/FACC").hasRole("FACC")
                        .requestMatchers("/api/oaaaT/**", "/api/oaaaF/**", "/api/data/GeneralC").hasRole("GENERALC")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login.html") // 指定登录页面的URL
                        .successHandler(customAuthenticationSuccessHandler)
                        //登录成功跳转DA.html
//                        .defaultSuccessUrl("/User.html", true)

                        .permitAll() // 允许所有用户访问登录页面
                )
                .logout(LogoutConfigurer::permitAll) // 允许所有用户退出登录
                .csrf(csrf -> csrf.disable()) // 禁用CSRF保护
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
