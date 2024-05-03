package com.sds.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.movieapp.domain.Notice;
import com.sds.movieapp.exception.NoticeException;
import com.sds.movieapp.model.cs.notice.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//게시물 목록
	@GetMapping("/cs/notice/list")
	public String getList() {
		
		return "cs/notice/list";
	}
	
	//글쓰기 폼 요청 처리 
	@GetMapping("/cs/notice/writeform")
	public String getWriteForm() {
		return "cs/notice/regist";
	}
	
	//글쓰기 요청 처리 
	@PostMapping("/cs/notice/regist")
	public String regist(Notice notice) {
		noticeService.insert(notice); //3단계: 글 등록
		
		return "redirect:/cs/notice/list";
	}
	
	@ExceptionHandler(NoticeException.class)
	public ModelAndView handle(NoticeException e) {
		ModelAndView mav = new ModelAndView("error/result");
		mav.addObject("e", e);
		
		return mav;
	}
	
}








