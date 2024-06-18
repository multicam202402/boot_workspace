package com.sds.securityapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration // 스프링의 빈 등록 시 xml기반이 아닌 자바 클래스 기반으로 지원하는 어노테이션
@EnableWebSecurity //시큐리티와 관련된 자동 설정들이 지원되는 어노테이션(무조건 사용하자)
public class SecurityConfig {
	
	
	//필터 체인 정보를 가진 빈 등록 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.authorizeHttpRequests(auth -> auth
			.requestMatchers("/").permitAll()
			.anyRequest().authenticated() //권한이 무엇이든 상관없이 무조건 로그인 한 유저에게만 허용
		);
		
		//스프링이 기본적으로 지원하는 디자인 폼을 쓰기 싫으면 아래처럼설정
		httpSecurity
			.formLogin(login->login
				.loginPage("/member/loginform").permitAll()
			);
		
		return httpSecurity.build();
	}
}













