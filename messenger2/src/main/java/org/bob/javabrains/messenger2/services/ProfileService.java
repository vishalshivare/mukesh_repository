package org.bob.javabrains.messenger2.services;

import java.util.ArrayList;
import java.util.List;

import org.bob.javabrains.messenger2.model.Profile;

public class ProfileService 
{
	public List<Profile> getAllProfile()
	{
	
		Profile p1=new Profile(1L,"Bob","Mukes","Kumar Munna");
		Profile p2=new Profile(2L,"Jenifer","Nandani","Prakash");
		List<Profile> list=new ArrayList<Profile>();
		list.add(p1);
		list.add(p2);
		return list;
	}

}
