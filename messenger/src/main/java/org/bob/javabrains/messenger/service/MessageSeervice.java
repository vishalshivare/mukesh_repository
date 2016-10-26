package org.bob.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.bob.javabrains.messenger.model.Message;
public class MessageSeervice
{
 
	public List<Message> getAllMessage()
	{
		Message m1=new Message(1l,"Hello Java Word", "Bob");
		Message m2=new Message(2l,"Hello RESETfull Word", "Bob");
		List<Message> l1=new ArrayList<>();
		l1.add(m1);
		l1.add(m2);
		return l1;
	}
}
