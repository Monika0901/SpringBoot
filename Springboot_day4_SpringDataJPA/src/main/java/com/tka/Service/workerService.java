package com.tka.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tka.Entity.worker;
import com.tka.dao.WorkerRepo;

@Service
public class workerService {
	@Autowired
    WorkerRepo repo;
	
	
	public String insertWokerData( worker w) {
		repo.save(w);
		return "Inserted";
		
	}
	public  Optional <worker> getSingleData(int id) {
		 return repo.findById(id);
		
		
	}
	public List<worker> getAll() {
	return repo.findAll();
	}
	public String deleteData(int id) {
		repo.deleteById(id);
		return "deleted...!";
	}
	public String updateData(worker w, int id) {
		worker w1 =repo.getById(id);
		w1.setId(w.getId());
		w1.setName(w.getName());
		w1.setCity(w.getCity());
		w1.setEmail(w.getEmail());
		w.setMb(w.getMb());
		return "updated";
		
	}
}
