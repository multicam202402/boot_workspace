package com.sds.movieapp.jwt;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//지금까지 스프링 시큐리티에서 자동으로 설정된 UsernamePasswordAuthenticationFilter 를
//이용하여, 전통적인 세션방식의 로그인을 처리했지만, 이 시점부터는 세션 방식의 로그인을 이용하지 않기
//위해 UsernamePasswordAuthenticationFilter 를 커스텀해야 한다..
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

}
