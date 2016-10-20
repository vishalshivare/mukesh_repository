package com.gh.HelloSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gh.HelloSpring.dao.EmployeeDAO;
import com.gh.HelloSpring.modal.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public Employee getEmployee(int id) throws Exception {
		try {
			return dao.selectEmployee(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Employee updateEmployeeById(Employee emp) throws Exception {
		try{
		return dao.updateEmployee(emp);
		}
		catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Employee stroreEmployee(Employee emp) throws Exception {
		try {
			return dao.addEmployee(emp);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Employee deleteEmployeeById(int id) throws Exception {
		try {
			return dao.deleteEmployee(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		try {
			return dao.getAllEmployees();
		} catch (Exception e) {
			throw e;
		}
	}

}
