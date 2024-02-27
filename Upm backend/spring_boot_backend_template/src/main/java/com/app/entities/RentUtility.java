package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Utility")
@Getter
@Setter
@ToString
public class RentUtility extends BaseEntity{
	
	@Column(nullable=false,name = "Rent_Amount")
	private double rentAmount;	
	
	@Column(name = "Electric_Bill",nullable=false)
	private double electricityBill;
	
	@Column(name="Water_Bill",nullable=false)
	private double waterBill;
	
	@Column(name="Gas_Bill",nullable=false)
	private double gasBill;
	
	@Column(name="Paid_Date")
	private LocalDate date;
	
	
}
