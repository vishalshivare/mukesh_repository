package org.poc.gh.ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.json.JSONObject;
import org.springframework.ldap.core.AttributesMapper;



@SuppressWarnings("rawtypes")
public class ContactAttributeMapperJson implements AttributesMapper 
{

	@Override
	public Object mapFromAttributes(Attributes attributes) throws NamingException 
	{
		NamingEnumeration<String> ids=attributes.getIDs();
		JSONObject Jobject=new JSONObject();
		while(ids.hasMore())
		{
			String id=ids.next();
			
			
			try
			{
			Jobject.put(id, attributes.get(id).get());
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return Jobject.toString();
	}

}
