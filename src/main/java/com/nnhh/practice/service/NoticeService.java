package com.nnhh.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnhh.practice.dto.NoticeSaveReqDto;
import com.nnhh.practice.model.Company;
import com.nnhh.practice.model.Notice;
import com.nnhh.practice.repository.CompanyRepository;
import com.nnhh.practice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	private final CompanyRepository companyRepository;
	
	@Transactional
	public void saveNotice(NoticeSaveReqDto dto) {
		
		Company company1 = new Company();
		company1.setComId(1);
		company1.setName("NH Company");
		company1.setNation("Korea");
		company1.setArea("Seoul");

		Company company2 = new Company();
		company2.setComId(2);
		company2.setName("SSS ");
		company2.setNation("Korea");
		company2.setArea("Busan");

		companyRepository.save(company1);
		companyRepository.save(company2);
		
		Company selectedCompany = companyRepository.findById(dto.getComId())
				.orElseThrow(()-> new IllegalArgumentException("ID가 없습니다."));
		
		Notice notice = Notice.builder()
				.position(dto.getPosition())
				.compensation(dto.getCompensation())
				.content(dto.getContent())
				.skill(dto.getSkill())
				.company(selectedCompany)
				.build();
		
		noticeRepository.save(notice);
	}

}
