package org.poc.gh.StudentDemoHQ.service;

import java.util.List;

import org.poc.gh.StudentDemoHQ.dao.StudentDao;
import org.poc.gh.StudentDemoHQ.exception.StudentNotFoundException;
import org.poc.gh.StudentDemoHQ.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	


	// INSERT STUDENT
	public String insertStudent(Student student) {
		return studentDao.insertStudent(student);

	}

	

	// SELECT STUDENT BY ROLL NO
	public Student getStudentByRoll(int roll) throws StudentNotFoundException {
		return studentDao.getStudentByRoll(roll);
	}

	// DELETE STUDENT BY ROLL NO
	public String deleteStudentByRoll(int roll) throws StudentNotFoundException {
		return studentDao.deleteStudentByRoll(roll);
	}

	// SELECT ALL STUDENT
	public List<Student> getStudent() {
		return studentDao.getStudents();
	}

	// UPDATE THE STUDENT RECORD
	public Student updateStudent(int roll, Student student) throws StudentNotFoundException {
		return studentDao.updateStudent(roll, student);
	}

	// LOGIN
	public boolean login(Student student) throws StudentNotFoundException {
		return studentDao.login(student);
	}

	
	

	

}
