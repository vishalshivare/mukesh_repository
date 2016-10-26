package org.bob.javabrains.messenger2.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;


@Path("inject")
public class InjectDemo 
{
	@Path("annotation")
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	public String paramUsingAnnotation(@MatrixParam("param")      String param,
			                           @HeaderParam("authSession") String header,
			                           @CookieParam("JSESSIONID") String cookie)
	{
		return "MAtrix PAram:"+param+"\n AuthSession: "+header+"\n Cookie: "+cookie;
	}
	
	@Path("context")
	@GET
    public String getParamUsingContext(@Context UriInfo uinfo,@Context HttpHeaders header)
    {
		String path=uinfo.getAbsolutePath().toString();
		String cookie=header.getCookies().toString();
		return "PAth: "+path+ "\n Cookie: "+cookie;
    }
}
