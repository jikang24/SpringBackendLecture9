package com.sprint.misson.springsecurity.config;

import com.sprint.misson.springsecurity.filter.JwtLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults())

        .addFilterBefore(
            new JwtLoggingFilter(),
            UsernamePasswordAuthenticationFilter.class
        );

    return http.build();
  }

  @Bean
    /*
	    CommandLineRunner로 인해
	    Spring Boot 애플리케이션이 완전히 실행된 직후 자동으로 실행
    */
  public CommandLineRunner printFilters(

      // 현재 프로젝트에 등록된 SecurityFilterChain Bean 주입
      // SecurityFilterChain 타입 Bean이 여러 개일 수 있으므로
      // @Qualifier("filterChain")로 명시적으로 지정
      @Qualifier("filterChain")
      SecurityFilterChain securityFilterChain
  ) {

    // 애플리케이션 실행 완료 후 자동 실행되는 로직
    // Spring Boot 시작 직후 콘솔에 필터 목록 출력
    return args -> {

      System.out.println();
      System.out.println("===== Spring Security Filter 목록 =====");

      // 현재 SecurityFilterChain에 등록된 필터 목록 조회
      List<Filter> filters = securityFilterChain.getFilters();

      // 등록된 필터들을 순서대로 출력
      for (int i = 0; i < filters.size(); i++) {

        System.out.println(
            // 필터 실행 순서 번호
            (i + 1) + ". "

                // 필터 클래스명 출력
                // 예: UsernamePasswordAuthenticationFilter
                + filters.get(i)
                .getClass()
                .getSimpleName()
        );
      }
    };
  }
}
