package com.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlatDto {
	
	private int flatNo;
	
	private int floorNo;
	
	private String type;
	
	private String address;
}
