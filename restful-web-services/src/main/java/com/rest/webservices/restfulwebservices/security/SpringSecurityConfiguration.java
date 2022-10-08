package com.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		1) 모든 요청이 인증
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//		2) 만약 인증되지 않으면
        http.httpBasic(withDefaults());

//		3) CSRF -> POST, PUT
        http.csrf().disable();  // 얘를 꼭 해줘야함
        return http.build();
    }
}
