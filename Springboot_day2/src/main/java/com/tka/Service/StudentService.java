package com.tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.Dao.StudentDao;
import com.tka.entities.Student;

@Service

public class StudentService {
	
	@Autowired
	StudentDao dao;
	
	public String insertData( Student s) {
		String msg = dao.insertData(s);
		return msg;
	}
	
	
	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		return msg;
		
	}


	public Student getSingleData(int id) {
	   Student std = dao.getSingleDta(id);
		return std;
	}


	public List<Student> getAllRecord() {
		List<Student> list = dao.getAllRecord();
		return list;
	}


	public String updateData(Student s, int id) {
		String msg = dao.updateData(s, id);
		return msg;
	}

	

	
}
