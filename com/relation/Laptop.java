package com.relation;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;

@Entity
public class Laptop {
//	public Student getStd() {
//		return std;
//	}
//	public void setStd(Student std) {
//		this.std = std;
//	}
	@Id
	private int id;
	private String name;
	
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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	//----------------------------	this is one to many -----------------------------------
//	@ManyToOne
//	private Student std;
//	
//	@Override
//	public String toString() {
//		return "Laptop [id=" + id + ", name=" + name + ", std=" + std + "]";
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
	//----------------------------this is many to many---------------------------------------
	@ManyToMany
	private List<Student> student;
	
	
	
}
