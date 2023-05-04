package com.example.h2.dto;

import lombok.Data;

@Data
public class ResponseDto {

	public ResponseDto(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	private String message;
	private Object data;
}
