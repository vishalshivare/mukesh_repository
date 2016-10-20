package org.poc.gh.StudentDemoHQ.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="mystudent")
public class Student {

	@Id
	@Column
	@GeneratedValue
	private int roll;

	/*
	 * @NotNull(message = "The _name field should not be null")
	 * 
	 * @Pattern(regexp = "[a-z-A-Z]*", message =
	 * "The name field value should be only alphabete")
	 */
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String mailId;
	@Column
	private String address;
	@Column
	private Date dob;
	@Column(name="course")
	private String courseName;
	@Column
	private String gender;

	/*
	 * @NotNull
	 * 
	 * @Size(min=10,max=10,message="mobile number shoud be 10")
	 * 
	 * @Pattern(regexp="(^$|[0-9]{10})")
	 */
	@Column(name="mobile")
	private long mobileNo;
	@Column(name="emergencymobile")
	private long emergencyNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getEmergencyNo() {
		return emergencyNo;
	}

	public void setEmergencyNo(long emergencyNo) {
		this.emergencyNo = emergencyNo;
	}

}
