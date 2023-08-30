package com.hql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HqlDB {
		@Id
		private int id;
		private String name;
		private int marks;

		
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
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
		
		
		@Override
		public String toString() {
			return "HqlDB [id=" + id + ", name=" + name + ", marks=" + marks + "]";
		}
}
