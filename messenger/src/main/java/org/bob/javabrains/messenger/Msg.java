package org.bob.javabrains.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msg")
public class Msg 
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg()
	{
		return " NEw Message";
	}

}
