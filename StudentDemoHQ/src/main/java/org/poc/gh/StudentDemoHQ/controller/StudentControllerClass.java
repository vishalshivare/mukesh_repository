package org.poc.gh.StudentDemoHQ.controller;


import java.util.List;

import javax.validation.Valid;

import org.poc.gh.StudentDemoHQ.exception.StudentNotFoundException;
import org.poc.gh.StudentDemoHQ.model.Student;
import org.poc.gh.StudentDemoHQ.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping()
public class StudentControllerClass 
{ 
	final private Logger logger=LoggerFactory.getLogger(StudentControllerClass.class);
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET, produces="application/JSON" , consumes="application/JSON" )
	public boolean login(@RequestParam int roll,@RequestParam String name) throws StudentNotFoundException
	{
		logger.info("Entering in  method login()::  in StudentControllerClass");
		Student student =new Student();
		student.setName(name);
		student.setRoll(roll);
		return studentService.login(student);
	}
	
	@RequestMapping(value="/")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}
	
	
	@RequestMapping(value="/student",method=RequestMethod.GET, produces="application/JSON", consumes="application/JSON")
	public List<Student> getStudent() throws Exception
	{
		logger.info("Entering in  method getStudent()::  in StudentControllerClass");
		return studentService.getStudent();
		
	}
	
	@RequestMapping(value="/student/{roll}", method=RequestMethod.GET, produces="application/JSON")
	public Student getStudentByRoll( @PathVariable int roll) throws StudentNotFoundException
	{
		logger.info("Entering in  method getStudentByRoll()::  in StudentControllerClass");
		 return studentService.getStudentByRoll(roll);
	}
	
	@RequestMapping(value="/student/{roll}", method=RequestMethod.DELETE, produces="application/JSON")
	public String deleteStudent(@PathVariable int roll) throws StudentNotFoundException
	{
		logger.info("Entering in  method deleteStudent()::  in StudentControllerClass");
		return studentService.deleteStudentByRoll(roll);
	}
	
	@RequestMapping(value="/student" , method=RequestMethod.POST, produces="application/JSON" , consumes="application/JSON")
	public String insertStudent(@Valid @RequestBody Student student)
	{
		logger.info("Entering in  method insertStudent() in StudentControllerClass");
		return	studentService.insertStudent(student);   //this will insert record in STUDENT table 
        //return StudentService.insertHQ(student);             //this will insert record in Student table using HIBERNATE 
		//return studentService.save(student);
	}
	
	@RequestMapping(value="/student/{roll}", method=RequestMethod.PUT, produces="application/JSON" , consumes="application/JSON")
	public Student updateStudent(@PathVariable int roll ,@RequestBody Student student) throws StudentNotFoundException
	{
		logger.info("Entering in  method updateStudent():: in StudentControllerClass");
		return studentService.updateStudent(roll, student);
	}
	
	

}
	
	
	

