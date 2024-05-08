package com.sds.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.movieapp.domain.CommentsDoc;
import com.sds.movieapp.domain.MovieDoc;
import com.sds.movieapp.exception.CommentsException;
import com.sds.movieapp.model.comments.CommentsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestCommentsController {

	@Autowired
	private CommentsService commentsService;
	
	// 영화평 등록 요청을 처리
	@PostMapping("/movie/comments")
	public ResponseEntity registComments(CommentsDoc commentsDoc, MovieDoc movie) {
		
		log.debug("댓글 단 사람은" + commentsDoc.getMember_idx());

		log.debug("영화제목은 "+movie.getMovieNm());
		
		for (int i = 0; i < movie.getGenres().length; i++) {
			log.debug("장르는 " + movie.getGenres()[i]);
		}
		for (int i = 0; i < movie.getDirectors().length; i++) {
			log.debug(" 감독은 " + movie.getDirectors()[i]);
		}
		for (int i = 0; i < movie.getActors().length; i++) {
			log.debug("배우명은 " + movie.getActors()[i]);
		}

		log.debug("영화평은 " + commentsDoc.getContent());

		commentsService.registComments(commentsDoc, movie);

		ResponseEntity entity = ResponseEntity.ok("몽고DB 등록 성공");

		return entity;
	}

	@ExceptionHandler(CommentsException.class)
	public ResponseEntity handle(CommentsException e) {
		ResponseEntity entity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return entity;
	}

}
