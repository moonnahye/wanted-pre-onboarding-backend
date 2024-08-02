package com.nnhh.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.nnhh.practice.model.Notice;
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
	public String saveNoticePage() {
		return "saveNoticeForm";
	}
	
	// 상세한 공고 페이지
	@GetMapping("/notice/{id}")
	public String showDetailPage(@PathVariable int id, Model model, @RequestParam int comId) {
		model.addAttribute("notice",noticeService.getNoticeDetail(id));
		model.addAttribute("noticeByComId", noticeService.getNoticeByComId(comId));
		return "noticeDetail";
	}
	
	// 채용공고 수정 페이지
		@GetMapping("/notice/{id}/updateForm")
		public String updateNoticePage(@PathVariable int id, Model model) {
			model.addAttribute("notice",noticeService.getNoticeDetail(id));
			return "updateNoticeForm";
		}
		
		//채용공고 리스트 페이지 (홈) 
		@GetMapping("/search")
		public String search(Model model, @RequestParam String keyword) {
			 List<Notice> notices = noticeService.getNoticeByKeyword(keyword);
			 model.addAttribute("keyword", keyword);
			 model.addAttribute("notices", notices );
			 
			return "searchResult";
		}
}
