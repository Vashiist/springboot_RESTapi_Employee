package com.jspiders.Employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.Employee.Repository.EmployeeRepository;
import com.jspiders.Employee.dto.Employee;

@Repository
public class EmployeeDao 
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee insertEmployee(Employee employee) {
		Employee employee2 = employeeRepository.save(employee);
		return employee2;
	}
	
	public Optional<Employee> findEmployeeById(int employeeId){
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		return optional;
	}
	
	public List<Employee> findAllEmployee(){
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	
	public String deleteById(int employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee Data Deleted";
	}
	
	public String deleteAll() {
		employeeRepository.deleteAll();
		return "All the records deleted";
	}
	
	public Employee updateEmployee(int employeeId, Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if(emp.isPresent()) 
		{
			Employee employee2 = employeeRepository.save(employee);
			return employee2;
		}
		else 
		{
			throw new IllegalArgumentException("Invalid ID");
		}
	}
	
	public Employee login(String emailId) {
		Employee emp = employeeRepository.findByEmail(emailId);
		return emp;
	}
}
 