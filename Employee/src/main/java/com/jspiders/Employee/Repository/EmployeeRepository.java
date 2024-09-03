package com.jspiders.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.Employee.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByEmail(String emailId);

}
