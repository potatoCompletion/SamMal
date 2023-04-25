package com.sammal.plantation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()  // csrf 정책 미적용
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 세션 사용 비활성화 (토큰 사용하기 때문)
//                .and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/h2-console","/hello", "/home", "/join").permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
                .formLogin()
                .usernameParameter("userId")  // 넘겨받는 로그인 파라미터명 커스텀 (기본 username)
                .passwordParameter("password")
                .loginPage("/login-page")  // 로그인 프로세스 url (직접 구현 x, 내부 생성)
                .loginProcessingUrl("/login")
                .permitAll();

        return http.build();
    }
}
