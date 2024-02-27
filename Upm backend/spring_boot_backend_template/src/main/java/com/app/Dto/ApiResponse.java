package com.app.Dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
	private String message;
	private LocalDateTime date;
	
	public ApiResponse(String msg) {
		this.message=msg;
		this.date=LocalDateTime.now();	
	}
	
}
