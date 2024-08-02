package com.nnhh.practice.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnhh.practice.dto.NoticeSaveReqDto;
import com.nnhh.practice.dto.ResponseDto;
import com.nnhh.practice.model.Notice;
import com.nnhh.practice.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class noticeApiController {

	private final NoticeService noticeService;

	// 데이터 저장하기
	@PostMapping("/api/notice")
	public ResponseDto<String> save(@RequestBody NoticeSaveReqDto dto) {
		noticeService.saveNotice(dto);
		return new ResponseDto<>(HttpStatus.OK.value(), "성공");
	}

	// 데이터 삭제하기
	@DeleteMapping("/api/notice/{id}")
	public ResponseDto<String> save(@PathVariable int id) {
		noticeService.deleteNotice(id);
		return new ResponseDto<>(HttpStatus.OK.value(), "성공");
	}

	// 데이터 수정하기
	@PutMapping("/api/notice/{id}")
	public ResponseDto<String> update(@PathVariable int id, @RequestBody Notice requestNotice) {
		noticeService.updateNotice(id, requestNotice);
		return new ResponseDto<>(HttpStatus.OK.value(), "성공");
	}

}
