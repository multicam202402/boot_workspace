package com.sds.movieapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestMovieController {

	//영화평 등록 요청을 처리 
	@PostMapping("/movie/comments")
	public ResponseEntity regist() {
		//영화평 작성자? 
		//제작 국가정보 
		//장르 
		//감독
		//배우 
		//영화평
		return null;
	}
	
}





