package com.sds.movieapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//스프링 3.0 부터 스프링빈 xml 파일을 대신하여 어노테이션 기반으로 설정할 수 있도록 지원..
/*
 <bean id="msg" class="SecurityFilterChain">
 	<constructor-args value="바보"/>
 </bean> 
 */ 
@Configuration
public class SecurityConfig {
	
	//우리가 spring mvc 에서 AOP를 이용하여 uri를 걸러낸 작업을 스프링 부트 시큐리티에서는 보다 쉽고 체계적으로
	//지원...
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		//필터링 할 uri 명시..
		httpSecurity
			.authorizeHttpRequests(
					(auth) -> auth
					.requestMatchers("/site/**","/", "/member/loginform", "/member/login").permitAll() 
					.requestMatchers("/cs/notice/list").hasRole("USER") //권한명은 개발자가 회원가입 시 지정하면 됨..
			);
	
		httpSecurity
			.formLogin((auth)->
				auth.loginPage("/member/loginform").loginProcessingUrl("/member/login")
			);
		
		//토큰 비활성화 
		httpSecurity.csrf((auth)->auth.disable());
		
		return httpSecurity.build();
	}
	
}











