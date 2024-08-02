package com.nnhh.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nnhh.practice.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class noticeController {
	
	private final NoticeService noticeService;
	
	//채용공고 리스트 페이지 (홈) 
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("notice", noticeService.getNoticeList());
		return "index";
	}
	
	//채용공고 등록 페이지
	@GetMapping("/notice/saveForm")
	public String savePage() {
		return "saveNoticeForm";
	}
	
	// 상세한 공고 페이지
	@GetMapping("/notice/{id}")
	public String showDetailPage(@PathVariable int id, Model model) {
		model.addAttribute("notice",noticeService.getNoticeDetail(id));
		return "noticeDetail";
	}
	
	
	

}
