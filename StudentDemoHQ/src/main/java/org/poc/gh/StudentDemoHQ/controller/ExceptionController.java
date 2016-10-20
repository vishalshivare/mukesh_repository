package org.poc.gh.StudentDemoHQ.controller;

import org.poc.gh.StudentDemoHQ.exception.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@ControllerAdvice
public class ExceptionController 
{
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The student does not exists in the system")
	@org.springframework.web.bind.annotation.ExceptionHandler
	public void handleStudentNotFoundException(StudentNotFoundException exception) 
	{
		logger.error(exception.getMessage(), exception);
	}

	
	private Logger logger=LoggerFactory.getLogger(ExceptionController.class);
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Either server or database is down")
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e)
	{
		logger.error(e.getMessage(),e);
		return "error";
	}
	
	
		@ExceptionHandler(value = MethodArgumentNotValidException.class)
		public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
			logger.error(exception.getMessage(), exception);
	       // return new ResponseEntity<String>(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	        return exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(); 
		} 


}
