package org.poc.gh.StudentDemoHQ.dao;



import java.util.List;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.poc.gh.StudentDemoHQ.exception.StudentNotFoundException;
import org.poc.gh.StudentDemoHQ.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class StudentDao  
{

	private Logger logger=LoggerFactory.getLogger(StudentDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	//LOGIN: USER AUTHENTICATIO
	public  boolean login(Student student) throws StudentNotFoundException
	{
		boolean authenticated=false;
/*
		try(Connection con=Utility.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(2, student.getRoll());
			pst.setString(1, student.getName());
			try(ResultSet rs=pst.executeQuery();)
			{
				if(rs.next())
					authenticated=true;	
				else
				throw new StudentNotFoundException("Invalid User-Id or Password");
			}
		}
		catch(SQLException e)
		{	logger.error(e.getMessage(),e); }*/

		return authenticated;
	}

	//METHOD TO SELECT RECORD FROM DATABASE
	public  List<Student>  getStudents()
	{ 
		
		//List list=new ArrayList<Student>();
		List<Student> list= sessionFactory.openSession().createQuery("from Student").list();
		 
		return list;
	}

	//METHOD TO SELECT RECORD BY ROLL  FROM DTABASE
	public Student getStudentByRoll(int roll) throws StudentNotFoundException
	{
		Student stu=null;
		try
		{	
			stu=(Student) sessionFactory.openSession().get(Student.class, roll);
			if(stu==null)
				throw new StudentNotFoundException("Student Not Found..");
		}
		catch(HibernateException e)
		  {logger.error(e.getMessage(),e);  }

		return stu;
	}

	//METHOD TO INSERT RECORD INTO DATABASE
	public  String insertStudent(Student student)
	{
		
		String status="Record Inserted Successfully";
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		return status;
	}

	//METHOD TO DELETE RECORD FROM DATABASE
	public  String deleteStudentByRoll(int roll) throws StudentNotFoundException
	{
		String msg="Deleted Successfully";
		try
		{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Student student=(Student)session.get(Student.class, roll);
			if(student==null)
			{
				msg="Record Not Found";
				throw new StudentNotFoundException("Record Not found For Deletion");
			}
			else
				session.delete(student);
			transaction.commit();
			session.close();
			
		}
		catch(HibernateError e)
		 { logger.error(e.getMessage(),e);
		 }
		return msg;
	}

	//METHOD TO UPDATE RECORD INTO DATABSE
	public  Student updateStudent(int roll,Student student) throws StudentNotFoundException
	{
		Student stu=null;
		
		try
		 {
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			stu=(Student)session.get(Student.class, roll);
			if(stu==null)
			{
				
				throw new StudentNotFoundException("No Record Found For Updation");
			}
			else
			{
				stu.setName(student.getName());
				stu.setMailId(student.getMailId());
				stu.setAddress(student.getAddress());
				stu.setCourseName(student.getCourseName());
				stu.setMobileNo(student.getMobileNo());
				stu.setEmergencyNo(student.getEmergencyNo());
				session.update(stu);
				transaction.commit();
				session.close();
				
			}
			
		}
		catch(HibernateException e)
		{ logger.error(e.getMessage(),e);  }
		return stu;
	}
	//METHOD TO CLOSE CONNECTION

}
