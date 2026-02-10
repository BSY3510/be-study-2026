package com.example.be_study_2026.week5_advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())               // Postman 테스트를 위해 CSRF 보호 비활성화
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll()                     // 누구나 접근 가능
                .anyRequest().authenticated()                                   // 인증만 하면 접근 가능
            )
            .httpBasic(basic -> {});                // Postman 사용을 위해 HTTP Basic Auth 사용

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
