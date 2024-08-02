package com.nnhh.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnhh.practice.model.Company;

public interface CompanyRepository  extends JpaRepository<Company, Integer>{

}
