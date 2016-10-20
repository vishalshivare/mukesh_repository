package com.gh.HelloSpring.modal;

import java.util.Date;

public class EmployeeClass {
	private int empid;
	private String fname;
	private String lname;
	private String email;
	private Date dob;
	private String address;
	private String mobile;
	private Date createdDate;
	private Date lastModified;
	private String status;
	
	public EmployeeClass(int empid, String fname, String lname, String email, Date dob, String address, String mobile,
			Date createdDate, Date lastModified, String status) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.mobile = mobile;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
