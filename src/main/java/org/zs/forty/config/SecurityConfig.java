package org.zs.forty.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.zs.forty.security.JwtAccessDeniedHandler;
import org.zs.forty.security.JwtAuthTokenFilter;
import org.zs.forty.security.JwtAuthenticationEntryPoint;
import org.zs.forty.security.JwtAuthorizationManager;
import org.zs.forty.security.JwtLogoutSuccessHandler;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/22
 * @description: Security 配置
 **/
@Configuration
@EnableWebSecurity

@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  
  public static final String API_AUTH = "/api/auth/**";
  private final JwtLogoutSuccessHandler jwtLogoutSuccessHandler;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final UserDetailsService userDetailsService;
  private final JwtAuthTokenFilter jwtAuthTokenFilter;
  private final JwtAuthorizationManager jwtAuthorizationManager;
  
  /**
   * 密码编码器
   */
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  /**
   * 身份验证管理器
   */
  @Bean
  public AuthenticationManager authenticationManager(
      BCryptPasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    return new ProviderManager(daoAuthenticationProvider);
  }
  
  /**
   * @description: 配置SecurityFilterChain过滤器链
   * @Param: HttpSecurity
   * @Return: SecurityFilterChain
   */
  @Bean
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity)
      throws Exception {
    // 设置白名单
    httpSecurity.authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.GET, // Swagger的资源路径需要允许访问
            "/doc.html/**",
            "/v3/api-docs/**",
            "/swagger-ui/index.html/**",
            "/swagger-ui.html/**",
            "/swagger-resources/**"
        ).permitAll()
        .requestMatchers(HttpMethod.POST, API_AUTH).permitAll() // 登录放行
        .anyRequest().access(jwtAuthorizationManager)
    );
    httpSecurity.logout(logout -> logout.logoutUrl("/api/auth/logout")
            .logoutSuccessHandler(jwtLogoutSuccessHandler))
        .addFilterBefore(jwtAuthTokenFilter,
            UsernamePasswordAuthenticationFilter.class)
        // 异常处理器
        .exceptionHandling(exception -> exception
            .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .accessDeniedHandler(jwtAccessDeniedHandler))
        
        // 禁用登录页面
        .formLogin(AbstractHttpConfigurer::disable)
        // 禁用登出页面
        .logout(AbstractHttpConfigurer::disable)
        // 禁用session
        .sessionManagement(AbstractHttpConfigurer::disable)
        // 禁用httpBasic
        .httpBasic(AbstractHttpConfigurer::disable)
        // 禁用csrf保护
        .csrf(AbstractHttpConfigurer::disable)
        // 禁用cors跨域
        .cors(AbstractHttpConfigurer::disable);
    
    return httpSecurity.build();
  }
}