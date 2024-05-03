package com.sds.movieapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
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
}








