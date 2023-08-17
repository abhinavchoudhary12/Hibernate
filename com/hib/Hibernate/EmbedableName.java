package com.hib.Hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class EmbedableName {
	private String Fname; 
	private String Lname;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	
	
}
