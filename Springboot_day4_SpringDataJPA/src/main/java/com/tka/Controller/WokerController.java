package com.tka.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Entity.worker;
import com.tka.Service.workerService;

@RestController
public class WokerController {
    @Autowired
	  workerService service;
	
    @PostMapping("/insert")
	public String InsertWokerData( @RequestBody  worker w) {
    	
    	return service.insertWokerData(w);
		}
    
    @GetMapping("/getSingle/{id}")
    public Optional<worker> getSingleData(@ PathVariable int id) {
    	 return service.getSingleData(id);
    }
    	 
    @GetMapping("/getAll")
    	public List<worker> getAll() {
    		return service.getAll();
    	}
    	
    	@DeleteMapping("/delete/{id}")
    	public String deletedta(@PathVariable int id ){
    		return service.deleteData(id);
    		
    	}
    	
    	@PutMapping("/update/{id}")
    	public String updateData(@RequestBody worker w, @PathVariable int id) {
    		return service.updateData(w, id);
    	}
    	
    }

