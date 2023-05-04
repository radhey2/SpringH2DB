package com.example.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.h2.dto.RequestDto;

public interface Repository extends JpaRepository<RequestDto, Integer> {

	List<RequestDto> findBydept(String dept);

}
