package com.sds.movieapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.movieapp.document.Comments;
import com.sds.movieapp.domain.Actor;
import com.sds.movieapp.domain.Director;
import com.sds.movieapp.domain.Genre;
import com.sds.movieapp.domain.MemberDoc;
import com.sds.movieapp.domain.MovieDoc;
import com.sds.movieapp.domain.Nation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestMovieController {

	//영화평 등록 요청을 처리 
	@PostMapping("/movie/comments")
	public ResponseEntity regist(MemberDoc member, MovieDoc movie, Comments comments) {
		
		System.out.println("호출여부 ");
		
		//영화평 작성자? 
		System.out.println("member_idx = "+member.getMember_idx());
		
		//장르
		for(int i=0;i<movie.getGenres().length;i++) {
			System.out.println("장르명 "+movie.getGenres()[i]);
		}
		
		//영화명
		System.out.println("영화명 "+movie.getMovieNm());
		
		//감독
		for(int i=0;i<movie.getDirectors().length;i++) {
			System.out.println("감독명 "+movie.getDirectors()[i]);
		}
		
		//배우
		for(int i=0;i<movie.getActors().length;i++) {
			System.out.println("배우명 "+movie.getActors()[i]);
		}
		
		//제작 국가정보 
		for(int i=0;i<movie.getNations().length;i++) {
			System.out.println("국가명 "+movie.getNations()[i]);
		}

		//영화평
		System.out.println("영화평 "+comments.getContent());
		
		return null;
	}
	
}





