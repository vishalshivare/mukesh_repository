package org.bob.javabrains.messenger2.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile 
{
	
	private long id;
	private String profileName;
	private String firstName;
	private String secondName;
	private Date created;
	
	public Profile()
	{
		
	}

	public Profile(long id, String profileName, String firstName, String secondName)
	{
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.secondName = secondName;
	//	this.created = created;
	}
	//GETTER AND SETTER

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	

}
