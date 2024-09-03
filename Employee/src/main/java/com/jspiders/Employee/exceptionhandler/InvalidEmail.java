package com.jspiders.Employee.exceptionhandler;

public class InvalidEmail extends RuntimeException{

	public InvalidEmail(String message) {
		super(message);
	}
	
}
