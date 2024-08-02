package com.nnhh.practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=30)
	private String position;
	
	@Column(nullable=false)
	private int compensation;
	
	@Column(nullable = false, length = 100)
	private String content;
	
	@Column(nullable = false, length = 50)
	private String skill;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="comId")
	private Company company;

}
