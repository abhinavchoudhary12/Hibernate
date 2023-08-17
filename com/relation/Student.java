package com.relation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="StudentL")
public class Student {
	@Id
	private int rollno;
	private String name;
	private String Dep;
//	@OneToOne
//	private Laptop laptop;
	
	//by default fetch is lazy
	//in lazy it only fetch the single class
	//in Eiger fetch it fetch all columns of
	//forign table and primary table depend upon
	//primary table
	@OneToMany(mappedBy="std",fetch=FetchType.EAGER)
	private List<Laptop> laptop=new ArrayList<Laptop>();
	
	
	
	
//	public Laptop getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
	
	
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return Dep;
	}
	public void setDep(String dep) {
		Dep = dep;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", Dep=" + Dep + ", laptop=" + laptop + "]";
	}
	
	
}
