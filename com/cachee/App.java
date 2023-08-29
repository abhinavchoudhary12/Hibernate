package com.cachee;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flat.class);
		
		StandardServiceRegistry builder=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory= config.buildSessionFactory(builder);
		
		
		Session session=factory.openSession();
		
//		Flat f=new Flat();
//		f.setCity("Ghaziabad");
//		f.setPrice("2.5 million");
//		f.setRoom("1 rooms");
		
		
		//session.save(f);
		
//		-------first level cache------------
//		here it will query only once and get 2 objects because it is using first level cache
//		
		
		
//		Flat f=null;
//		f=(Flat) session.get(Flat.class,1);
//		Flat f1=(Flat) session.get(Flat.class,1);
//		System.out.println(f);
//		System.out.println(f1);
		
//		----------2level cache----------------
		
//		Flat f=(Flat) session.get(Flat.class,1); 
//		session.beginTransaction().commit();
//		session.close();
//		
//		Session session1=factory.openSession();
//		Flat f1=(Flat) session1.get(Flat.class,1); 
//		System.out.println(f);
//		System.out.println(f1);
//
//
//		session1.beginTransaction().commit();
//		session1.close();

		
		
//		----------2 level cache with query------------------
		
		Query query=session.createQuery("From Flat where flatno=3");
		
//		to have 2 level cache
	
		query.setCacheable(true);
		session.beginTransaction();
		
		Flat q=(Flat) query.uniqueResult();
		
		System.out.println(q);
	
		session.getTransaction().commit();
		session.close();
		
		
		Session session1=factory.openSession();
		session1.beginTransaction();
		Query query1=session1.createQuery("From Flat where flatno=3");
		
//		to have 2 level cache

		query1.setCacheable(true);
		Flat q1=(Flat) query1.uniqueResult();
		System.out.println(q1);
		session1.getTransaction().commit();
		session1.close();
	}

}
