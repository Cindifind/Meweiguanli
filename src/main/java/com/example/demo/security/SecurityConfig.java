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
        http.cors(cors -> cors.configurationSource(request -> {
                    org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
                    config.setAllowCredentials(true);
                    config.addAllowedOriginPattern("*"); // 允许所有域
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");
                    return config;
                }))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers( "/login.html","index.html","ad.html","register.html","ds.zip").permitAll()
                        .requestMatchers("/login","/api/GetAd", "/api/visitor","api/example","api/AddUsers","api/departments/list","api/departments/listAll","/api/data/FindVisitorByOpenId").permitAll()
                        .requestMatchers("/js/**","/font/**","/css/**","/font-awesome/**","/layui/**").permitAll()
                        .requestMatchers("/api/departments/add","/api/departments/delete/**").hasRole("ADMIN")
                        .requestMatchers( "api/data/FindUser","api/delUsers/**","api/enabledT/*/*").hasRole("ADMIN")
                        .requestMatchers("/api/approve1T","/api/approve1F").hasRole("LEVEL")
                        .requestMatchers("/api/approve2T","/api/approve2F").hasAnyRole( "LEVEL2")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login.html") // 指定登录页面的URL
                        .successHandler(customAuthenticationSuccessHandler)
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
