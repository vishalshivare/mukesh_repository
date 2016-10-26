package org.bob.javabrains.messenger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Test")
public class Test 
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	{
		return "Test Class";
	}

}
