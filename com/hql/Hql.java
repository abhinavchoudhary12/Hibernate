package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hib.Hibernate.Student;

public class Hql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration config=new Configuration().configure("hibernate.cfg.xml");
		
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SessionFactory factory=config.buildSessionFactory(registry);
		
		Session session=factory.openSession();
		
		
		String query="from embeddingname";
		
		System.out.println("he");
		Query q=session.createQuery(query);
		
		List<Student> l=q.list();
		for(Student s:l) {
			System.out.println(s.getName()+" "+s.getCourse()+" "+s.getId());
		
		}
		
		//session.beginTransaction().commit();
	}

}
