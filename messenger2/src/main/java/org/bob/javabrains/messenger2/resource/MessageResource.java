package org.bob.javabrains.messenger2.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bob.javabrains.messenger2.MyResource;
import org.bob.javabrains.messenger2.model.Message;
import org.bob.javabrains.messenger2.services.MessageService;

@Path("/message")
public class MessageResource 
{
	MessageService ms=new MessageService();
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size)
	{
		if(year>0 && start>0)
		return ms.getAllMessageForYear(year, start, size);
		else if(year>0 )
		return ms.getAllMessageForYear(year);
		else	
		return ms.getAllMessageMap();
	}
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId") long messageId)
	{
		return  MessageService.getMessage(messageId);
		
	}
	//IMPLEMENTATION OF POST 
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg)
	{
		return ms.addMessage(msg);
	}
	
	//IMPLEMENTING UPDATE METHOD
	@Path("/{messageId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId,Message msg)
	{
		msg.setId(messageId);
		return ms.updateMessage(msg);
	}
	
	//IMPLEMENTING DELETE METHOD
	@Path("/{msgId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message removeMessage(@PathParam("msgId") long Id)
	{
		return ms.removeMessage(Id);
	}
	//----------FILTERING & PAGINATION----------
	
	
}
