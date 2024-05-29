package com.sds.movieapp.jwt;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//지금까지 스프링 시큐리티에서 자동으로 설정된 UsernamePasswordAuthenticationFilter 를
//이용하여, 전통적인 세션방식의 로그인을 처리했지만, 이 시점부터는 세션 방식의 로그인을 이용하지 않기
//위해 UsernamePasswordAuthenticationFilter 를 커스텀해야 한다..
//주의) 이 클래스를 재정의 한다는 것 자체가 jwt를 이용하는것은 아니다!~! 단지 이 클래스는 로그인 하는 순간을 제어할 수 있는
//클래스인 것 뿐이다..
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	//AuthenticationManager 는 인터페이스이고, 스프링시큐리티 내부적으로 생성되어 처리되므로, 
	//개발자는 스프링으로부터 얻어와 사용해야 한다..
	
	private AuthenticationManager authenticationManager;

	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager; 
	}
	
	
	
	//사용자가 로그인하려고 할때...
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		//사용자가 로그인폼에서 전송한 아이디,패스워드이 이 메서드로 전달되는지 부터 체크 
		String username = this.obtainUsername(request);
		String password = this.obtainPassword(request);
		
		System.out.println("username is ======================"+username);
		System.out.println("password is ======================"+password);
		
		log.debug("username is ======================"+username);
		log.debug("password is ======================"+password);
		
		//유저명과 비밀번호를 UsernamePasswordAthenticationToken 객체에 담아놓고, 
		//스프링 시큐리티로 하여금, db를 연동하여 회원정보를 인증하는 절차를 시키자!!
		//CustomerUserDetailsService 객체를 이용하여 db를 조회해주는 객체가 바로 AuthenticationManager 였다..
		Authentication auth=new UsernamePasswordAuthenticationToken(username, password, null);
		
		return authenticationManager.authenticate(auth); // CustomUserDetailsService의 db조회 메서드 호출!!
	}
	
	//스프링 시큐리티가 무조건 username  파라미터를 찾으므로, 만일 개발자가 다른 이름의 파라미터를 이용하고 있다면
	//object~ 메서드를 재정의하면 된다
	@Override
	protected String obtainUsername(HttpServletRequest request) {
		return request.getParameter("uid");
	}
	
	
	//사용자가 인증 성공되면...
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		log.debug("회원정보가 존재합니다.로그인 성공");
	}
	
	//사용자 인증이 실패되면..
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		log.debug("회원정보가 없습니다.로그인 실패");
	}
	
}



