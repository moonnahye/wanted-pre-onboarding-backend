package com.nnhh.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnhh.practice.model.Notice;

public interface NoticeRepository  extends JpaRepository<Notice, Integer>{

}
