package com.tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Entity.Department;
import com.tka.dao.Departmentdao;

@Service
public class DepartmentService {
@Autowired
	Departmentdao dao ;
	
	public String insertData(Department d) {
		String msg = dao.insertData(d);
		return msg;

	}

	public String deleteData(int dep_id) {
		String msg = dao.deleteData(dep_id);
		return msg;
	}

	public Department getSingleData(int dep_id) {
		 Department dep = dao.getSingleDta(dep_id);
		return dep;
	}

	public List<Department> getAllRecord() {
		List<Department> list = dao.getAllRecord();
		return list;
	}

	public String updateData(Department d, int dep_id) {
		String msg = dao.updateData(d, dep_id);
		return msg;
	}

}
