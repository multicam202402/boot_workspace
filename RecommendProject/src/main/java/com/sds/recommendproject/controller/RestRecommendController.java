package com.sds.recommendproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sds.recommendproject.domain.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestRecommendController {
	
	//클라이언트가 요청 헤더에 전달한 토큰을 넘겨받아, jwt를 꺼내보자 (인증: 클라우드 서비스를 이용하는 회원여부를 판단)
	
	@GetMapping("/list")
	public List<Movie> getList(@RequestHeader("Authorization") String header) {
		
		log.debug("넘겨받은 헤더중 Authorization 의 값은 "+header);
		
		return null;
	}
}




