package org.poc.gh.service;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.poc.gh.model.UserModel;
import org.springframework.ldap.core.AttributesMapper;

@SuppressWarnings("rawtypes")
public class UserService implements AttributesMapper
{

	@Override
	public Object mapFromAttributes(Attributes attributes) throws NamingException 
	{
		UserModel user=new UserModel();
		NamingEnumeration<String> ids=attributes.getIDs();
		while(ids.hasMore())
		{
			String id=ids.next();
			
			
		}
		
		return null;
	}

}
