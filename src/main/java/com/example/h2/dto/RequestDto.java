package com.example.h2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "REQUEST_DTO")
public class RequestDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DEPT")
	private String dept;
	@Column(name = "SALARY")
	private String salary;
	@Column(name = "ABOUT")
	private String about;
}
