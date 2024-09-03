package com.jspiders.Employee.ResponseStructure;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ResponseStructure <T>
{
	private T data;
	private String message;
	private LocalDateTime datetime;
	private HttpStatus status;
	private int statusCode;
}
