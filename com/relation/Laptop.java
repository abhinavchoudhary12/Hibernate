package com.relation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	public Student getStd() {
		return std;
	}
	public void setStd(Student std) {
		this.std = std;
	}
	@Id
	private int id;
	private String name;
	
	
	@ManyToOne
	private Student std;
	
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", std=" + std + "]";
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
	
	
	
}
