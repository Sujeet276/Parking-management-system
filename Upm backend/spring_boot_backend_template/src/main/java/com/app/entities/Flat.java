package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flat extends BaseEntity {

	@Column(nullable = false,name = "Flat_No")
	private int flatNo;
	
	@Column(nullable = false,name= "Floor_No")
	private int floorNo;
	
	@Column(nullable=false,name="Flat_Type")
	private String type;
	
	@Column(nullable=false,name="address")
	private String address;
	
	@Column(nullable=false,name="VacantStatus")
	private boolean Vacant=false;
	
	@OneToOne
	@JoinColumn(name = "Owner_Id")
	private Owner owner;
	
	@OneToOne
	@JoinColumn(name="Tenant_Id")
	private User tenant;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Flat_Id")
	private List<RentUtility> rentList=new ArrayList<RentUtility>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Flat_Id")
	private List<Image> imageList=new ArrayList<Image>();
	
	
	public void addImage(Image image) {
		imageList.add(image);
	}
	
	public void removeImage(Image image) {
		imageList.remove(image);
	}
	
		
}

