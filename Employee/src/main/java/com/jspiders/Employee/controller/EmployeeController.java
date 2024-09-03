package com.jspiders.Employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.Employee.ResponseStructure.ResponseStructure;
import com.jspiders.Employee.Service.EmployeeService;
import com.jspiders.Employee.dto.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;

	
//	localhost:8080/insert
	@PostMapping("/insert")
	public ResponseEntity<?> insertEmployee(@RequestBody Employee employee)
	{
		ResponseStructure<Employee> structure = employeeservice.insertEmployee(employee);
		return new ResponseEntity<> (structure,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam Employee employee)
	{
		ResponseStructure<Employee> structure = employeeservice.login(employee.getEmpEmail(), employee.getEmpPass());
		return new ResponseEntity<> (structure,HttpStatus.FOUND);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<?> findEmployeeById(@RequestParam int employeeId)
	{
		ResponseStructure<Optional<Employee>> structure = employeeservice.findEmployeeById(employeeId);
		return new ResponseEntity<> (structure, HttpStatus.FOUND);
	}
	
	@GetMapping("/findAllEmployee")
	public ResponseEntity<?> findAllEmployee()
	{
		ResponseStructure<List<Employee>> structure = employeeservice.findAllEmployee();
		return new ResponseEntity<> (structure,HttpStatus.FOUND); 
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<?> deleteEmployeeById(@RequestParam int employeeId)
	{
		ResponseStructure<?> structure = employeeservice.deleteEmployeeById(employeeId);
		return new ResponseEntity<> (structure,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll()
	{
		ResponseStructure<?> structure = employeeservice.deleteAll();
		return new ResponseEntity<> (structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee)
	{
		ResponseStructure<Employee> structure = employeeservice.updateEmployee(employeeId, employee);
		return new ResponseEntity<> (structure,HttpStatus.CREATED);
	}
}
