package org.poc.gh.MailDemo.controller;

import org.poc.gh.MailDemo.Service.MailService;
import org.poc.gh.MailDemo.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class MailController 
{
	private Logger logger=LoggerFactory.getLogger(MailController.class); 
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value=("/sinup"),method=RequestMethod.GET,produces="application/JSON")
	public String sinup()
	{
		return " Please Sinup before any operation....";
	}
	
	@RequestMapping(value=("/sinup"), method=RequestMethod.POST, produces="application/JSON" , consumes="application/JSON")
	public String sinupSuccess(@RequestBody Users user)
	{
		 System.out.println(user.getUsername()+" "+user.getMailid());
		try
		{
			mailService.sendMail(user);
		}
		catch(MailException e)
		{
			logger.info("Error in Sending Mail: "+e);
        }
		
		return "Sinup done Successfully...:"+user.getUsername();
	}

}
