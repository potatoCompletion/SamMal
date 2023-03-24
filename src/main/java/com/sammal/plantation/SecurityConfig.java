package com.sammal.plantation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()  // csrf 정책 미적용
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 세션 사용 비활성화 (토큰 사용하기 때문)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()  // 권한없이 접근가능한 url
                .anyRequest().authenticated()  // 모든 요청에 대해 인증된 사용자만 가능
                .and()
                .formLogin()
                .usernameParameter("userId")  // 넘겨받는 로그인 파라미터명 커스텀 (기본 username)
                .passwordParameter("password")
                .loginProcessingUrl("/login")  // 로그인 프로세스 url (직접 구현 x, 내부 생성)
                .permitAll();

        return http.build();
    }
}
