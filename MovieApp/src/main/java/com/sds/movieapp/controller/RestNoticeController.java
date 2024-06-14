package com.sds.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sds.movieapp.domain.Member;
import com.sds.movieapp.domain.NoticeDoc;
import com.sds.movieapp.exception.JwtException;
import com.sds.movieapp.jwt.JwtValidService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestNoticeController {
	
	@Autowired
	private JwtValidService jwtValidService;
	
	//글쓰기 요청 처리 
	@PostMapping("/rest/cs/notice")
	public ResponseEntity regist(@RequestHeader("Authorization") String header, NoticeDoc noticeDoc) {
		
		log.debug("글쓰기 요청 받음");
		
		String token = header.replace("Bearer", "");
		
		Member member = jwtValidService.getMemberFromJwt(token);
		
		if(member ==null) {
			throw new JwtException("로그인이 필요한 서비스입니다");
		}
		
		return null;
	}
	
}







