package com.hib.Hibernate;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity(name="College")

/**
 * @author HP
 *
 */
@Entity(name="EmbeddingName")
public class Student {
	@Id
	private int id;
	private String Course;
//	@Column(name="Student_Name")
	private EmbedableName Name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public EmbedableName getName() {
		return Name;
	}
	public void setName(EmbedableName name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Course=" + Course + ", Name=" + Name + "]";
	}
	
}
