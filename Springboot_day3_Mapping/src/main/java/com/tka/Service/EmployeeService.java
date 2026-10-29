package com.tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Entity.Department;
import com.tka.Entity.Employee;
import com.tka.dao.Employeedao;



@Service 
public class EmployeeService {
	
	@Autowired
	Employeedao dao;

	public String insert(Employee e) {
		String msg = dao.insert(e);
		return msg;
	}

	public String delete(int emp_id) {
		String msg = dao.delete(emp_id);
		return msg;
		
	}

	public Employee  getSingle(int emp_id) {
		Employee  e= dao.getSingle(emp_id);
		return e;
	}

	public List<Employee> getAll() {
		List<Employee> list = dao.getAll();
		return list;
	}

	public String updateData(Employee e, int emp_id) {
		String msg = dao.updateData(e, emp_id);
		return msg;
	}

}
