package com.jspiders.Employee.exceptionhandler;

public class InvalidEmployeeId extends RuntimeException{

	public InvalidEmployeeId(String message) {
		super(message);
	}
	
}
