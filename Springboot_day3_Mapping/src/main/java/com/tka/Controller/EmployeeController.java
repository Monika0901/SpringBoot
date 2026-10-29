package com.tka.Controller;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Entity.Department;
import com.tka.Entity.Employee;
import com.tka.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService Service;
	
	@PostMapping("/insertEmployee")
	public String insert(@RequestBody Employee e) {
		String msg = Service.insert(e) ;
		return msg;
	}
	
	@DeleteMapping("/deleteEmployee/{emp_id}")
		public String delete(@PathVariable int emp_id ) {
		String msg= Service.delete(emp_id);
		return msg;
	}
	
	@GetMapping("/GetSingleEmployee")
	public Employee  getSingle(@RequestParam int emp_id) {
		Employee e = Service.getSingle(emp_id);
		return e ;
	}
	
	
	@GetMapping("/getAllEmployee")
	public List<Employee>getSingle(){
		List<Employee>list= Service.getAll();
		return list;
		
	}
	@PutMapping("/updateEmployee/{emp_id}")
	public String updateData(@RequestBody Employee  d,@PathVariable int emp_id) {
		String msg = Service.updateData(d,emp_id);
		return msg;
	}
}
