package com.relation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
//			Laptop laptop=new Laptop();
//			Laptop laptop1=new Laptop();
//			Student std=new Student();
//			Student std1=new Student();
//			List<Student> l=new ArrayList<Student>();
//			List<Laptop> l1=new ArrayList<Laptop>();
//
//			laptop.setId(101);
//			laptop.setName("mac");
//			std.setRollno(1);
//			std.setDep("MCA");
//			std.setName("Abhinav Choudhary");
//			
//			
//			laptop1.setId(102);
//			laptop1.setName("HP");
//			
//			std1.setRollno(2);
//			std1.setDep("MCA");
//			std1.setName("abhishek dagar");
//			
//			l.add(std);
//			l1.add(laptop);			
//			
//			l.add(std1);
//			l1.add(laptop1);			
//			laptop.setStudent(l);
//			std.setLaptop(l1);
			

			
			Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
			ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			SessionFactory factory=config.buildSessionFactory(reg);
			Session session=factory.openSession();
			
			Transaction trans=session.beginTransaction();
			
//			session.save(std);
//			session.save(laptop);
//			session.save(std1);
//			session.save(laptop1);
			
			
			
			Student s=(Student) session.get(Student.class,1);
			System.out.println(s.getName()+" "+s.getRollno()+" "+s.getDep()+"--> ");
			
			List<Laptop> l=s.getLaptop();
			for(Laptop lap:l) {
				System.out.println(lap.getId()+" "+lap.getName()+" "+lap.getStudent());
				
			}
			trans.commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
