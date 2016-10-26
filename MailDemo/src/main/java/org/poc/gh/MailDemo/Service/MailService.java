package org.poc.gh.MailDemo.Service;

import org.poc.gh.MailDemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) 
	{
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail(Users user) throws MailException
	{
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(user.getMailid());
		mail.setFrom("muk.cse07@gmail.com");
		mail.setSubject("Registration");
		mail.setText("Dear Mr./Mrs. "+user.getUsername()+" your Registration Done Successfully...");
		javaMailSender.send(mail);
		
	}
	
}
