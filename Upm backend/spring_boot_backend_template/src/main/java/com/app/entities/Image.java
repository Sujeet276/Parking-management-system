package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Flat_Image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity{
	
	@Lob
	@Column(nullable=false,name = "image_data")
	private byte[] ImageData;
	

}
