package org.bob.javabrains.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bob.javabrains.messenger.model.Message;
import org.bob.javabrains.messenger.service.MessageSeervice;

@Path("/message")
public class MessageResource
{
	/*MessageSeervice ms=new MessageSeervice();
	
	//@GET
	@Produces(MediaType.APPLICATION_XML)	
	public List<Message> getMessage()
	{
		return ms.getAllMessage();
		
	}  */
	@GET
	@Produces(MediaType.TEXT_PLAIN)	
	public String msg()
	{
		return "Ok it's Working!";
	}

}
