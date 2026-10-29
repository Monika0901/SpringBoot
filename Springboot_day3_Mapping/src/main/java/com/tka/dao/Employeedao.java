package com.tka.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Entity.Department;
import com.tka.Entity.Employee;

@Repository
public class Employeedao {
	
	@Autowired
	SessionFactory factory; 
	
	public String insert(Employee e) {
	 Session session = factory.openSession();
	 Transaction tr = session.beginTransaction();
	 
	 session.persist(e);
	 tr.commit(); 
	 session.close();
	 
	 return "inserted....!";

	}
	
	public String delete( int emp_id) {
	Session session = factory.openSession();
	Transaction tr = session.beginTransaction();
	
	Employee e = session.find(Employee.class, emp_id) ;
     session.remove(e);
     tr. commit();
     session.close();
	
	
	return  "deleted....";
	
	}

	public Employee  getSingle(int emp_id) {
		
		Session session = factory.openSession();
		  Transaction tr= session.beginTransaction();
	
		  String hqlQuery ="from Employee where emp_id=:emp_id";
		  
		  Query query = session.createQuery(hqlQuery);
		  query.setParameter("emp_id", emp_id);

			Employee  e = (Employee) query.getSingleResult();

			tr.commit();
			
			session.close();
		     
			return e;
		  
	}
	
	 public List<Employee> getAll() {
			
		 Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			String hqlQuery = "from Employee";

			Query query = session.createQuery(hqlQuery);

			List<Employee> list = query.getResultList();

			tx.commit();
			session.close();

			return list;
	 }
	 
	 
	 public String updateData(Employee e, int emp_id) {

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Employee  emp = session.find(Employee.class, emp_id);
		     emp.setEmp_name(e.getEmp_name());
		     emp.setDepartment(e.getDepartment());
			 
			session.merge(emp);

			tx.commit();
			session.close();

			return "updated ... !";

		}
	
}
