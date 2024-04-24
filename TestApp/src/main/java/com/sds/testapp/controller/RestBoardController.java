package com.sds.testapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.testapp.domain.Board;
import com.sds.testapp.exception.BoardException;
import com.sds.testapp.model.board.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestBoardController {
	//Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	//글쓰기 요청 처리 
	@PostMapping("/board")
	public ResponseEntity regist(Board board) {		
		//log.trace("글쓰기 요청 받음"); //@Sl4f  로 설정할 경우 log 로 사용
		log.trace("title is "+board.getTitle());
		log.trace("writer is "+board.getWriter());
		log.trace("content is "+board.getContent());
		
		boardService.insert(board); //3단계: 일 시키기 
		
		//몸체없이 헤더에 200을 심어서 응답
		ResponseEntity entity=ResponseEntity.status(HttpStatus.OK).build();  
		
		return entity;
	}
	
	//게시물 목록 요청 처리 
	@GetMapping("/board")
	public List getList() {
		log.trace("게시물 목록 요청 받음");
		
		return null;
	}
	
	
	@ExceptionHandler(BoardException.class)
	public ResponseEntity handle(BoardException e) {
		//500
		ResponseEntity entity=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		return entity;
	}
}









