package com.tka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.Entity.worker;

@Repository
public interface WorkerRepo extends JpaRepository<worker, Integer>{
	

}
