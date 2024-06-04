package com.sds.recommendproject.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration // 스프링의 빈을 등록 및 관리할 수 있는 xml을 대신할 수 있는 클래스로 선언 
@EnableWebSecurity // 스프링 시큐리티의 커스터마이징을 가능하게 하는 설정
public class SecurityConfig {

}
