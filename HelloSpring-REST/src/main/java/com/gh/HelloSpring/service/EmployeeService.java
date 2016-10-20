package com.gh.HelloSpring.service;

import java.util.List;

import com.gh.HelloSpring.modal.Employee;

public interface EmployeeService {

	Employee getEmployee(int id) throws Exception;

	Employee updateEmployeeById(Employee emp) throws Exception;

	Employee stroreEmployee(Employee emp) throws Exception;

	Employee deleteEmployeeById(int id) throws Exception;

	List<Employee> getAllEmployee() throws Exception;

}
