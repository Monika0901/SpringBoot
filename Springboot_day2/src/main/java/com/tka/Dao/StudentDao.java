package com.tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Student;

@Repository
public class StudentDao {
	
	@Autowired
	SessionFactory factory;
	
	
	//insert
	public String insertData( Student s) {
		
		Session session = factory.openSession();
		     Transaction tx  = session.beginTransaction();
		     
		     session.persist(s);
		     
		     tx.commit();
		     session.close();
		     
		   return "inserted";
		
	}
	
	
     public String  deleteData( int id) {
		
		Session session = factory.openSession();
		     Transaction tx  = session.beginTransaction();
		     
		     Student s = session .find(Student.class , id);
		    		 
		     session.remove(s);
		     
		     tx.commit();
		     session.close();
		     
		   return "deleted";
		
	}

     

	 public Student getSingleDta(int id) {
		 Session session = factory.openSession();
	     Transaction tx  = session.beginTransaction();
	     
	     String hqlQuery = "from Student where id=:id";

			Query query = session.createQuery(hqlQuery);
			query.setParameter("id", id);

			 Student s = (Student) query.getSingleResult();

			tx.commit();
			session.close();
		      return s;
		 
	     
	 }


	 public List<Student> getAllRecord() {
		
		 Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			String hqlQuery = "from Student";

			Query query = session.createQuery(hqlQuery);

			List<Student> list = query.getResultList();

			tx.commit();
			session.close();

			return list;
	 }
	 
	 public String updateData(Student s, int id) {

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Student std = session.find(Student.class, id);
			std.setName(s.getName());
			std.setBranch(s.getBranch());
			std.setYear(s.getYear());

			session.merge(std);

			tx.commit();
			session.close();

			return "updated ... !";

		}
	
	

}
