package com.nnhh.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class noticeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/notice/saveForm")
	public String savePage() {
		return "saveNoticeForm";
	}
	
	

}
