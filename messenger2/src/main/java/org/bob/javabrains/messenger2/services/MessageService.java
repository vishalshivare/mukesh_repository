package org.bob.javabrains.messenger2.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.bob.javabrains.messenger2.database.DatabaseClass;
import org.bob.javabrains.messenger2.model.Message;
import org.bob.javabrains.messenger2.model.Profile;


public class MessageService 
{
	static private Map<Long, Message> messages=DatabaseClass.getMessage();

	public MessageService()
	{
		messages.put(1L, new Message(1L,"Hello Bob","Bob"));
		messages.put(2L, new Message(2L,"Hello Jeny","Jenyfer"));
		messages.put(3L, new Message(3L,"Hello Petter","Petter"));
		messages.put(4L, new Message(4L,"Hello Anjelina","Anjelina"));
	}
	
	public List<Message> getAllMessage()
	{
		Message m1=new Message(1L,"Hello java Word","Bob");
		Message m2=new Message(2L,"Hello RESTful Word","Bob");
		List<Message> list=new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	
	public List<Message> getAllMessageMap()
	{
		return new ArrayList<Message>(messages.values());
		
	}
	 public static Message getMessage(long id)
	{
		return messages.get(id);
	}
	public Message addMessage(Message msg)
	{
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg)
	{
		if(msg.getId()<=0)
			return null;
		messages.put(msg.getId(), msg);
		return msg;
	}
	static	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
	//----------FILTERING & PAGINATION----------
	            //FILTERING
	static public List<Message> getAllMessageForYear(int year)
	{
		List<Message> message4year=new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
	 for(Message msg:messages.values())
		{
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year)
				message4year.add(msg);
		}
		return message4year;
	}
	        //PAGINATION 
	static public List<Message> getAllMessageForYear(int year,int start,int size)
	{
		int count=1;
		List<Message> message4year=new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
	 for(Message msg:messages.values())
		{
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year && msg.getId()>=start)
			{
				message4year.add(msg);
				if(++count>size)
					break;
			}
				
		}
		return message4year;
	}
	
	
}
