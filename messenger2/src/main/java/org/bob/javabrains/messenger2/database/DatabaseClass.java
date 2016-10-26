package org.bob.javabrains.messenger2.database;

import java.util.HashMap;
import java.util.Map;

import org.bob.javabrains.messenger2.model.Message;
import org.bob.javabrains.messenger2.model.Profile;

public class DatabaseClass 
{
	private static Map<Long,Message> messages=new HashMap<Long,Message>();
	private static Map<Long,Profile> profiles=new HashMap<Long,Profile>();
	
	public  static Map<Long,Profile> getProfile()
	{
		return profiles;
	}
	public  static Map<Long,Message> getMessage()
	{
		return messages;
		
	}
}
