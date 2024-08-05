package com.nnhh.practice.service;

import java.util.List;

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
	
	//채용공고 저장하기
	@Transactional
	public int saveNotice(NoticeSaveReqDto dto) {
		
		//Company 데이터 입력 
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
		return 1;
	}
	
	//채용공고 리스트 가져오기
	@Transactional(readOnly = true)
	public List<Notice> getNoticeList() {
		return noticeRepository.findAll();
	}
	
	//상세한 채용공고 가져오기
	@Transactional(readOnly = true)
	public Notice getNoticeDetail(int id) {
		return noticeRepository.findById(id).orElseThrow(()->
			new IllegalArgumentException("공고가 없습니다. 공고 ID:"+id));
	}
	
	//채용공고 삭제하기
	@Transactional
	public void deleteNotice(int id) {
		noticeRepository.deleteById(id);
	}
	
	//채용공고 수정하기
	@Transactional
	public int updateNotice(int id, Notice requestNotice) {
		
		Notice notice = noticeRepository.findById(id).orElseThrow(()->
		new IllegalArgumentException("공고가 없습니다. 공고 ID:"+id));
		
		notice.setPosition(requestNotice.getPosition());
		notice.setCompensation(requestNotice.getCompensation());
		notice.setContent(requestNotice.getContent());
		notice.setSkill(requestNotice.getSkill());
		
		return 1;
	}
	
	//검색어로 공고 목록 가져오기
	@Transactional(readOnly = true)
	public List<Notice> getNoticeByKeyword(String keyword){
		return noticeRepository.findByContentContainingOrPositionContainingOrSkillContaining(keyword, keyword, keyword);
	}
	
	//Company의 comId로 공고목록 가져오기
	@Transactional(readOnly = true)
	public List<Notice> getNoticeByComId(int ComId){
		return noticeRepository.findByCompany_ComId(ComId);
	}
 }
