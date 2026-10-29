package com.tka.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Entity.Department;

@Repository
public class Departmentdao {

	@Autowired
	SessionFactory factory;
	
	
	//insert
	public String insertData( Department s) {
		
		Session session = factory.openSession();
		     Transaction tx  = session.beginTransaction();
		     
		     session.persist(s);
		     
		     tx.commit();
		     session.close();
		     
		   return "inserted";
		
	}
	
	
     public String  deleteData( int dep_id) {
		
		Session session = factory.openSession();
		     Transaction tx  = session.beginTransaction();
		     
		     Department d = session .find(Department.class , dep_id);
		    		 
		     session.remove(d);
		     
		     tx.commit();
		     session.close();
		     
		   return "deleted";
		
	}

     

	 public Department getSingleDta(int dep_id) {
		 Session session = factory.openSession();
	     Transaction tx  = session.beginTransaction();
	     
	     String hqlQuery = "from Department where dep_id=:dep_id";

			Query query = session.createQuery(hqlQuery);
			query.setParameter("dep_id", dep_id);

			 Department  d = (Department) query.getSingleResult();

			tx.commit();
			
			session.close();
		     
			return d;
		 
	     
	 }


	 public List<Department> getAllRecord() {
		
		 Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			String hqlQuery = "from Department";

			Query query = session.createQuery(hqlQuery);

			List<Department> list = query.getResultList();

			tx.commit();
			session.close();

			return list;
	 }
	 
	 public String updateData(Department d, int dep_id) {

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Department  dep = session.find(Department.class, dep_id);
			dep.setDep_id(d.getDep_id());
			dep.setDep_name(d.getDep_name());

			session.merge(dep);

			tx.commit();
			session.close();

			return "updated ... !";

		}
	
	

}


