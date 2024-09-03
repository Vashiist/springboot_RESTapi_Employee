package com.jspiders.Employee.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	@NotNull
	@Pattern(regexp = "^[a-zA-z' ']")
	@Size(min = 3, max = 16)
	private String empName;
	private String empEmail;
	@Pattern(regexp = "^[0-9]")
	private String empContact;
	private String empPass;
}
