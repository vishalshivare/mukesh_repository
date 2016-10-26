package org.poc.gh.HibernateDemo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pk")
public class Users 
{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
