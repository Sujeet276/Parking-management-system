package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value = "owner")
@Getter
@Setter
@NoArgsConstructor
public class Owner extends User {
	
	@JsonIgnore
	@OneToMany(mappedBy = "owner",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Flat> list=new ArrayList<Flat>();
	
	public void addFlat(Flat flat) {
		list.add(flat);
		flat.setOwner(this);
	}
	
	public void removeFlat(Flat flat) {
		list.remove(flat);
		flat.setOwner(null);
	}
	
	public Owner(String name, String emailId, String password, String address, String contactNo,Role role){
		super(name, emailId, password, address, contactNo, role);
	}
	
	public Owner(String name, String emailId, String password, String address, String contactNo){
		super(name, emailId, password, address, contactNo, Role.OWNER);
	}
}
