package com.gh.HelloSpring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gh.HelloSpring.modal.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection conn;
	private PreparedStatement pst;
	private Employee employee;
	@Autowired
	DataSource dataSource;

	@Override
	public Employee selectEmployee(int id) throws Exception {
		try{
			employee=new Employee();
			conn=dataSource.getConnection();
			//conn=UtilsClass.getConnection();
			pst=conn.prepareStatement("select * from emp where empid=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery(); 
			if(rs.next())
			{
				employee.setEmpid(rs.getInt(1));
				employee.setFname(rs.getString(2));
				employee.setLname(rs.getString(3));
				employee.setDob(rs.getDate(4));
				employee.setAddress(rs.getString(5));
				employee.setMobile(rs.getString(6));
				return employee;
			}
		}catch (Exception e) {
			throw e;
		}
		finally {
			if(pst!=null)
				pst.close();
			conn.close();
			employee=null;
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws SQLException {
		try{
			conn=dataSource.getConnection();
			//conn=UtilsClass.getConnection();
			pst=conn.prepareStatement("update emp set fname=?,lname=?,dob=?,address=?,mobile=? where empid=?");
			pst.setString(1, emp.getFname());
			pst.setString(2, emp.getLname());
			pst.setDate(3, emp.getDob());
			pst.setString(4, emp.getAddress());
			pst.setString(5, emp.getMobile());
			pst.setInt(6,emp.getEmpid());
			pst.executeUpdate(); 
			return emp;
		}
		catch (SQLException e) {
			throw e;
		}
		finally {
			if(pst!=null)
				pst.close();
			conn.close();
		}
	}

	@Override
	public Employee addEmployee(Employee emp) throws Exception {
		try{
			conn=dataSource.getConnection();
			//conn=UtilsClass.getConnection();
			pst=conn.prepareStatement("insert into emp values(?,?,?,?,?,?)");
			pst.setInt(1,emp.getEmpid());
			pst.setString(2, emp.getFname());
			pst.setString(3, emp.getLname());
			pst.setString(5, emp.getAddress());
			pst.setString(6, emp.getMobile());
			pst.setDate(4, emp.getDob());
			pst.executeQuery(); 
			return emp;
		}catch (Exception e) {
			throw e;
		}
		finally {
			if(pst!=null)
				pst.close();
			conn.close();
		}
	}

	@Override
	public Employee deleteEmployee(int id) throws Exception {
		try{
			employee=new Employee();
			conn=dataSource.getConnection();
			//conn=UtilsClass.getConnection();
			pst=conn.prepareStatement("select * from emp where empid=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery(); 
			if(rs.next())
			{
				employee.setEmpid(rs.getInt(1));
				employee.setFname(rs.getString(2));
				employee.setLname(rs.getString(3));
				employee.setDob(rs.getDate(4));
				employee.setAddress(rs.getString(5));
				employee.setMobile(rs.getString(6));
			}
			pst=conn.prepareStatement("delete from emp where empid=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			return employee;
		}catch (Exception e) {
			throw e;
		}
		finally {
			if(pst!=null)
				pst.close();
			conn.close();
			employee=null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> empList=new ArrayList<>();
		try{
			conn=dataSource.getConnection();
			//conn=UtilsClass.getConnection();
			pst=conn.prepareStatement("select empid,fname,lname,dob,address,mobile from emp");
			ResultSet rs=pst.executeQuery(); 
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setEmpid(rs.getInt(1));
				emp.setFname(rs.getString(2));
				emp.setLname(rs.getString(3));
				emp.setDob(rs.getDate(4));
				emp.setAddress(rs.getString(5));
				emp.setMobile(rs.getString(6));
				empList.add(emp);
			}
		}catch (Exception e) {
			throw e;
		}
		finally {
			if(pst!=null)
				pst.close();
			conn.close();
		}
		return empList;	
	}
}
