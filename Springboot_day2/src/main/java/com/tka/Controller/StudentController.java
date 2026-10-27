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

import com.tka.Service.StudentService;
import com.tka.entities.Student;

@RestController
public class StudentController {
	@Autowired
    StudentService service ;
	
	@PostMapping("/insert")
	 public String  insertData( @RequestBody Student s) {
		 String msg=  service.insertData(s);
		 return msg;
		 
	 }
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.deleteData(id);
		return msg;
		
	}
	@GetMapping("/singleone")
	public Student getSingleData(@RequestParam int id) {
		 Student s = service.getSingleData(id);
		return s;
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllRecord() {
		List<Student> list = service.getAllRecord();
		return list;
	}
	
	@PutMapping("/update/{id}")
	public String updateData(@RequestBody Student s,@PathVariable int id) {
		String msg = service.updateData(s,id);
		return msg;
	}
}
