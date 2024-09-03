package com.jspiders.Employee.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jspiders.Employee.ResponseStructure.ResponseStructure;
import com.jspiders.Employee.dao.EmployeeDao;
import com.jspiders.Employee.dto.Employee;

@Service
public class EmployeeService
{
	
	@Autowired
	EmployeeDao employeeDao;
	
	public ResponseStructure<Employee> insertEmployee(Employee employee){
		
		Employee employee2 = employeeDao.insertEmployee(employee);
		
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setData(employee2);
		structure.setMessage("Employee inserted Successfully");
		structure.setDatetime(LocalDateTime.now());
		structure.setStatus(HttpStatus.CREATED);
		structure.setStatusCode(201);
		
		return structure;
	}
	
	public ResponseStructure<Optional<Employee>> findEmployeeById(int employeeId){
		
		Optional<Employee> employee2 = employeeDao.findEmployeeById(employeeId);
		
		if(employee2.isPresent())
		{
			ResponseStructure<Optional<Employee>> structure = new ResponseStructure<>();
			structure.setData(employee2);
			structure.setDatetime(LocalDateTime.now());
			structure.setMessage("Employee Details Found");
			structure.setStatus(HttpStatus.FOUND);
			structure.setStatusCode(301);
			return structure;
		}
		else {
			System.out.println("Service");
//			throw new invalidStudentId("InvalidID");
			return null;
		}
	}
	
	public ResponseStructure<List<Employee>> findAllEmployee(){
		List<Employee> list = employeeDao.findAllEmployee();
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setData(list);
		structure.setDatetime(LocalDateTime.now());
		structure.setMessage("All student data found");
		structure.setStatusCode(301);
		structure.setStatus(HttpStatus.FOUND);
		return structure;
	}
	
	public ResponseStructure<String> deleteEmployeeById(int emoployeeId){
		
		String message = employeeDao.deleteById(emoployeeId);
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(message);
		structure.setDatetime(LocalDateTime.now());
		structure.setMessage("Employee data deleted");
		structure.setStatusCode(302);
		structure.setStatus(HttpStatus.FOUND);
		return structure;
	}
	
	public ResponseStructure<String> deleteAll(){
		String message = employeeDao.deleteAll();
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(message);
		structure.setDatetime(LocalDateTime.now());
		structure.setMessage("All Employee Deleted");
		structure.setStatus(HttpStatus.FOUND);
		structure.setStatusCode(301);
		return structure;
	}
	
	public ResponseStructure<Employee> updateEmployee(int employeeId, Employee employee){
		
		Employee employee2 = employeeDao.updateEmployee(employeeId, employee);
		
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setData(employee2);
		structure.setDatetime(LocalDateTime.now());
		structure.setMessage("Employee Data Updated");
		structure.setStatusCode(301);
		structure.setStatus(HttpStatus.FOUND);
		return structure;
	}
	
	public ResponseStructure<Employee> login(String email, String password){
		
		Employee employee2 = employeeDao.login(email);
		if(employee2!=null)
		{
			if(email.equals(employee2.getEmpEmail())&&password.equals(employee2.getEmpPass()))
			{
				ResponseStructure<Employee> structure = new ResponseStructure<>();
				structure.setData(employee2);
				structure.setDatetime(LocalDateTime.now());
				structure.setMessage("Login Accepted");
				structure.setStatusCode(202);
				structure.setStatus(HttpStatus.FOUND);
				return structure;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
}
	

