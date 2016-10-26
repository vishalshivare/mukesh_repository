package org.bob.javabrains;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bob.javabrains.model.StudentDetail;
import org.bob.javabrains.model.Student_Info;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import org.hibernate.Session;

public class MainClass 
{
	public static void main(String[] args) 
	{
		/*Student_Info student=new Student_Info();
		student.setRoll(1236);
		student.setName("Golu ");
		student.setDob(new Date());*/
		StudentDetail sd=new StudentDetail();
		sd.setMobile("734565083");
		//sd.setRoll(123);
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();  
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		
		//session.save(student);
		//Student_Info s=(Student_Info)session.get(Student_Info.class, 1235);
		//System.out.println("Name of Student: "+s.getName());
		//s.setName("Krishna Mahaset");
		//session.delete(student);
		
		session.save(sd);
		
		transaction.commit();
		session.close();
		sf.close();
		
		
		System.out.println("Record Inserted Successfully...");
	}

}
