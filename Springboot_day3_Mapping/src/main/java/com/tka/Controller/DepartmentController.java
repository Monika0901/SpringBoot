package com.tka.Controller;

import java.util.List;

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
import com.tka.Service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
      DepartmentService service ;
	
	@PostMapping("/insert")
	 public String  insertData( @RequestBody Department d) {
		 String msg=  service.insertData(d);
		 return msg;
		 
	 }
	
	@DeleteMapping("/delete/{dep_id}")
	public String deleteData(@PathVariable int dep_id) {
		String msg = service.deleteData(dep_id);
		return msg;
		
	}
	@GetMapping("/singleone")
	public Department getSingleData(@RequestParam int dep_id) {
		 Department d = service.getSingleData(dep_id);
		return d;
	}
	
	@GetMapping("/getAllRecord")
	public List<Department> getAllRecord() {
		List<Department> list = service.getAllRecord();
		return list;
	}
	
	
	@PutMapping("/update/{dep_id}")
	public String updateData(@RequestBody Department  d,@PathVariable int dep_id) {
		String msg = service.updateData(d,dep_id);
		return msg;
	}
	
	
	
	
	

}
