package com.gh.HelloSpring.utils;

import javax.xml.ws.WebServiceException;

public class EmployeeNotFound extends WebServiceException {

	public EmployeeNotFound(Throwable e) {
		super("Employee Not Found", e);
	}
}
