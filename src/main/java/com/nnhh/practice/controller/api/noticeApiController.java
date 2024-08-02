package com.nnhh.practice.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnhh.practice.dto.NoticeSaveReqDto;
import com.nnhh.practice.dto.ResponseDto;
import com.nnhh.practice.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class noticeApiController {
	
	private final NoticeService  noticeService;
	
	//데이터 저장하기
	@PostMapping("/api/notice")
	public ResponseDto<String> save(@RequestBody NoticeSaveReqDto dto){
		noticeService.saveNotice(dto);
		return new ResponseDto<>(HttpStatus.OK.value(), "성공");
	}
	
	
	
	

}
