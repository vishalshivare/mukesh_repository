package org.bob.javabrains.messenger2.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.bob.javabrains.messenger2.model.Profile;
import org.bob.javabrains.messenger2.services.ProfileService;

@Path("profiles")
public class ProfileResource 
{
	ProfileService ps=new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getProfile()
	{
		return ps.getAllProfile();
	}

}
