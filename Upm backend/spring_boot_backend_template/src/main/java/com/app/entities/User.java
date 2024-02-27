package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@Table(name = "Users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, name = "emailId")
	private String emailId;

	@Column(nullable = false, name = "password")
	@JsonProperty(access = Access.READ_ONLY)
	private String password;

	@Column(nullable = false, name = "address")
	private String address;

	@Column(nullable = false)
	private String contactNo;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "tenant",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Flat> list=new ArrayList<Flat>();
	
	public void addFlat(Flat flat) {
		list.add(flat);
		flat.setTenant(this);
	}
	
	public void removeFlat(Flat flat) {
		list.remove(flat);
		flat.setTenant(null);
	}
	
	public User(String name, String emailId, String password, String address, String contactNo,Role role) {
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.role = role;
	}
	
	public User(String name, String emailId, String password, String address, String contactNo) {
		this(name, emailId, password, address, contactNo, Role.USER);
	}
	

	
}
