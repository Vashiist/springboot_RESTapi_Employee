package com.jspiders.Employee.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(InvalidEmployeeId.class)
	public ResponseEntity<?> invalidEmployeeId(InvalidEmployeeId invalidemployeeid)
	{
		ApiError api = new ApiError();
		api.setClass1(getClass());
		api.setDatetime(LocalDateTime.now());
		api.setMessage("Invalid Student Id");
		return new ResponseEntity<> (api,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<?> invalidPassword(InvalidPassword invalidPassword)
	{
		ApiError api = new ApiError();
		api.setClass1(getClass());
		api.setDatetime(LocalDateTime.now());
		api.setMessage("Invalid Password");
		return new ResponseEntity<> (api,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<?> invalidEmail(InvalidEmail invalidEmail)
	{
		ApiError api = new ApiError();
		api.setClass1(getClass());
		api.setDatetime(LocalDateTime.now());
		api.setMessage("Invalid EmailID");
		return new ResponseEntity<> (api,HttpStatus.NOT_FOUND);
	}
}
