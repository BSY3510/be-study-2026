package com.example.be_study_2026.week10;

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
                .requestMatchers("/menus", "/order").permitAll()        // 누구나 접근 가능
                .requestMatchers("/admin/**").hasRole("ADMIN")          // ADMIN 권한을 가진 사람만 접근 가능
                .anyRequest().authenticated()                                   // 인증만 하면 접근 가능
            )
            .httpBasic(basic -> {});                // Postman 사용을 위해 HTTP Basic Auth 사용

        return http.build();
    }

//    // 임시 사용자 생성(DB가 아닌 하드코딩으로 일단 구현)
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//            .username("user")
//            .password("{noop}1234")     // {noop}: 암호화 하지 않음(테스트용)
//            .roles("USER")
//            .build();
//
//        UserDetails admin = User.builder()
//            .username("admin")
//            .password("{noop}1234")
//            .roles("ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
