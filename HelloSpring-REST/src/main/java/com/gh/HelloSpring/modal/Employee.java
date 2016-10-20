package com.gh.HelloSpring.modal;

import java.sql.Date;

public class Employee {
	
	private int empid;
	private String fname;
	private String lname;
	private Date dob;
	private String address;
	private String mobile;
	
	public Employee() {
		System.out.println("def contr of emp");
	}
	
	public Employee(String fname, String lname, Date dob, String address, String mobile) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.address = address;
		this.mobile = mobile;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", address="
				+ address + ", mobile=" + mobile + "]";
	}
	
}
