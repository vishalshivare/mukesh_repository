package com.gh.HelloSpring.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gh.HelloSpring.modal.Employee;

public interface EmployeeDAO {

	Employee selectEmployee(int id) throws Exception;

	Employee updateEmployee(Employee emp) throws SQLException;

	Employee addEmployee(Employee emp) throws Exception;

	Employee deleteEmployee(int id) throws Exception;

	List<Employee> getAllEmployees() throws Exception;

}
