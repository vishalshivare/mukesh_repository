package com.gh.HelloSpring.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import com.gh.HelloSpring.modal.Employee;
import com.gh.HelloSpring.service.EmployeeService;
import com.gh.HelloSpring.utils.EmployeeNotFound;

@RestController
@RequestMapping
public class EmployeeControllerREST {

	@Autowired
	private EmployeeService service;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/")
	public ModelAndView index()
	{
		logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
		return new ModelAndView("home");
	}


	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET,produces="application/JSON")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id)
	{
		try {
			Employee emp=service.getEmployee(id);
			if(emp==null){
				return new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
				}
			else
				return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}catch (NullPointerException e) {
			throw new WebServiceException("Employee Not Found for id: "+id,e);
		} 
		catch (Exception e) {
			//throw new EmployeeNotFound(e);
			throw new WebServiceException("Error for id : "+id,e);
		}
	}



	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT,consumes="application/JSON",produces="application/JSON")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) 
	{
		try {
			Employee employee =service.updateEmployeeById(emp);
			if(employee.getFname()==null)
				return new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Employee>(employee, HttpStatus.OK)  ;
		} catch (Exception e) {
			throw new WebServiceException("Employee Not Updated",e);
		}
	}

	@RequestMapping(value="/emp",method=RequestMethod.POST,consumes="application/JSON",produces="application/JSON")
	public ResponseEntity<?> setEmployee(@RequestBody Employee emp)
	{
		try {
			Employee emp1=service.stroreEmployee(emp);
			System.out.println(emp1);
			return new ResponseEntity<Employee>(emp1, HttpStatus.OK)  ;
		} catch (Exception e) {
			throw new WebServiceException("Employee Not Inserted", e);
		}
	}

	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE) 
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) 
	{
		try {
			Employee employee =service.deleteEmployeeById(id);
			if(employee.getFname()==null)
				return new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Employee>(employee, HttpStatus.OK) ;
		} catch (Exception e) {
			throw new WebServiceException("Employee Not Deleted for id : "+id, e);
		}
	}


	@RequestMapping(value="/emps",method=RequestMethod.GET,produces="application/JSON")
	public ResponseEntity<?> getAllEmployee()
	{
		try {
			List<Employee> employeeList =service.getAllEmployee();
			if(employeeList.isEmpty())
				return new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<List>(employeeList, HttpStatus.OK) ;
		} catch (Exception e) {
			throw new WebServiceException("Employee List Not Found", e);
		}
	}


	@RequestMapping(value = "/emp/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<?> uploadFile(
			@RequestParam("uploadfile") MultipartFile uploadfile) {

		try {
			System.out.println("in controller");
			// Get the filename and build the local file path
			String filename = uploadfile.getOriginalFilename();
			String filepath = Paths.get("D:\\New folder (2)\\", filename).toString();

			// Save the file locally
			BufferedOutputStream stream =
					new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			//
	        byte[] bytes = uploadfile.getBytes();
	            stream.write(uploadfile.getBytes(), 0, bytes.length);
	      		//stream.write(uploadfile.getBytes());
			stream.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("file not uploaded",HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("uploaded successfully",HttpStatus.OK);
	}

	@RequestMapping(value="/test", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getSomeResource(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String dataDirectory = request.getServletContext().getRealPath("D:\\New folder (2)\\");
		Path file = Paths.get(dataDirectory, "image.jpg");
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=image.jpg");
		return new ResponseEntity<Object>(Files.copy(file, response.getOutputStream()), HttpStatus.OK);
	}

	@RequestMapping("/file/{fileName:.+}")
	public void downloadPDFResource( HttpServletRequest request, 
			HttpServletResponse response, 
			@PathVariable("fileName") String fileName) 
	{
		//If user is not authorized - he should be thrown out from here itself

		//Authorized user will download the file
		String dataDirectory = request.getServletContext().getRealPath("D:/New folder (2)/");
		Path file = Paths.get(dataDirectory, fileName);
		if (Files.exists(file)) 
		{
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename="+fileName);
			try
			{
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	@RequestMapping(value = "/file/{fileName}", method = RequestMethod.GET, produces = "application/JSON")
	public @ResponseBody void downloadA(@PathVariable("fileName") String fileName,HttpServletResponse response) throws IOException {
		File file = new File(fileName);
		InputStream in = new FileInputStream(file);
		response.setContentType("application/JSON");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		response.setHeader("Content-Length", String.valueOf(file.length()));
		FileCopyUtils.copy(in, response.getOutputStream());
	}

}
