package com.tka.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String branch;
	private int year;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student( String name, String branch, int year) {
		super();
		
		this.name = name;
		this.branch = branch;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", year=" + year + "]";
	}
	
	
	
	
}
