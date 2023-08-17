package com.relation;

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
			
			//Laptop laptop=new Laptop();
//			laptop.setId(104);
//			laptop.setName("mac2");
			//Student std=new Student();
//			std.setRollno(1);
//			std.setDep("MCA");
//			std.setName("abhishek dagar");
//			std.getLaptop().add(laptop);
//			laptop.setStd(std);
			Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
			ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			SessionFactory factory=config.buildSessionFactory(reg);
			Session session=factory.openSession();
			
			Transaction trans=session.beginTransaction();
			
			//session.save(std);
			//session.save(laptop);
			
			Student s=(Student) session.get(Student.class,1);
			System.out.println(s.getName()+" "+s.getRollno()+" "+s.getDep()+"--> ");
			List<Laptop> l=s.getLaptop();
			for(Laptop lap:l) {
				System.out.println(lap.getId()+" "+lap.getName()+" "+lap.getStd().getRollno());
				
			}
			trans.commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
