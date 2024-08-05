package com.nnhh.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnhh.practice.model.Notice;

public interface NoticeRepository  extends JpaRepository<Notice, Integer>{
	
	//SELECT * FROM notice 
	//WHERE content LIKE '%content%'
	//OR position LIKE '%position%' 
	//OR skill LIKE '%skill%';
	List<Notice> findByContentContainingOrPositionContainingOrSkillContaining(String content, String position,
			String skill);
	
	//SELECT * FROM notice WHERE comId = ?
	List<Notice> findByCompany_ComId(int comId);

}
