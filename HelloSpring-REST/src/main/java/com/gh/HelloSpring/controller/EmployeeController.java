package com.gh.HelloSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gh.HelloSpring.service.EmployeeService;

@Controller
@RequestMapping("/user")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/index")
	public String getIndexPage()
	{
		return "home";
	}
	
	@RequestMapping("/delete")
	public String getDeletePage()
	{
		return "delete";
	}
	
	@RequestMapping("/select")
	public String getSelectPage()
	{
		return "select";
	}
	
	@RequestMapping("/insert")
	public String getInsertPage()
	{
		return "insert";
	}
	
	@RequestMapping(value="/success")
	public String getSuccessPage()
	{
		return "success";
	}
	
}
