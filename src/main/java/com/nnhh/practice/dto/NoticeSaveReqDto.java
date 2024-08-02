package com.nnhh.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeSaveReqDto {
	
	private int comId;
	
	private String position;
	private int compensation;
	private String content;
	private String skill;

}
