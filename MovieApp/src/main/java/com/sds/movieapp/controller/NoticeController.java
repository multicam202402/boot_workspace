package com.sds.movieapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	@GetMapping("/cs/notice/list")
	public String getList() {
		
		return "";
	}
}
