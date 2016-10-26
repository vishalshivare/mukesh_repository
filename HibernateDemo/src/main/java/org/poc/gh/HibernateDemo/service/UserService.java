package org.poc.gh.HibernateDemo.service;

import java.util.List;

import org.poc.gh.HibernateDemo.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.poc.gh.HibernateDemo.model.Users;

@Service
public class UserService 
{
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<Users> getUSers()
	{
		return userDao.getUsers();
	}
	

}
