package com.hib.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	//inserting in table
        	//Student s1=new Student();
        	//s1.setCourse("MCA");
        	//s1.setId(1);
        	//s1.setName("akshat");
        	
        	
        	//Student std=null;
        	
        	//Embedding name        	
        	
        	Student s1=new Student();
        	EmbedableName em=new EmbedableName();
        	
        	em.setFname("Abhinav");
        	em.setLname("Choudhary");
        	
        	s1.setId(1);
        	s1.setCourse("MCA");
        	s1.setName(em);
        	
        	Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        	
        	
        	ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        	SessionFactory factory=config.buildSessionFactory(reg);
        	
        	Session session=factory.openSession();
        	
        	
        	Transaction trans=session.beginTransaction();
        	session.save(s1);
        	
        	//System.out.println("Record inserted: "+s1.getId()+" "+s1.getCourse()+" "+s1.getName());
        	
        	//fetching from table
//        	Student std= session.get(Student.class,3);
        	
//        	System.out.println("Fetched Records: "+std.toString());
        	
        	trans.commit();
        	
        	session.close();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
