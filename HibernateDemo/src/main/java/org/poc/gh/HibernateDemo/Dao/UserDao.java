package org.poc.gh.HibernateDemo.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.poc.gh.HibernateDemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Users> getUsers()
	{
		@SuppressWarnings("unchecked")
		List<Users> userList= (List<Users>) sessionFactory.getCurrentSession().createQuery("from pk").list();
		return userList;
	}

}
