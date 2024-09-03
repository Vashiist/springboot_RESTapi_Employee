package com.jspiders.Employee.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError 
{
	private LocalDateTime datetime;
	private String message;
	private Class class1;
}
