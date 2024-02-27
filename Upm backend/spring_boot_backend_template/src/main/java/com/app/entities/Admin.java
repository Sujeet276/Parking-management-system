package com.app.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@DiscriminatorValue(value = "admin")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Admin extends User {
	
	public Admin(String name, String emailId, String password, String address, String contactNo,Role role){
		super(name, emailId, password, address, contactNo, role);
	}
	
	public Admin(String name, String emailId, String password, String address, String contactNo){
		super(name, emailId, password, address, contactNo, Role.ADMIN);
	}
}
