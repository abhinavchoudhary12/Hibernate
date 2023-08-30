package com.hql;


import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class Hql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(HqlDB.class);
		
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SessionFactory factory=config.buildSessionFactory(registry);
		
		Session session=factory.openSession();
		
		session.beginTransaction();
		
 		

//		Random r=new Random();
//		for(int i=1;i<=20;i++) {
//			HqlDB hb=new HqlDB();
//			hb.setId(i);
//			hb.setLanguage("language of random is "+r.nextInt(1000));
//			hb.setName("name of random is "+r.nextFloat(1000));
//			session.save(hb);
//		}
		
//		------------getting single result-------------------
		
//		Query query=session.createQuery("from HqlDB where id=12");
//		HqlDB s=(HqlDB)	query.uniqueResult();
//		System.out.println(s);
		
//		------------getting multiple result-----------------
		
//		List<HqlDB> list =query.list();
//		for(HqlDB f:list) {
//		System.out.println(f);
//		}

//		-----------------getting result as an array----------------
		
//		Query query=session.createQuery("select id,language from HqlDB where id=19");
//		
//		Object[] obj=(Object[]) query.uniqueResult();
//		
//		System.out.println("id:language");
//		System.out.println(obj[0]+":"+obj[1]);
		
//		----------------------use of aggregation function like sum---------------
//		Random r=new Random();
//		for(int i=1;i<=20;i++) {
//			HqlDB hb=new HqlDB();
//			hb.setId(i);
//			hb.setMarks(r.nextInt(100));
//			hb.setName("name "+i);
//			session.save(hb);
//		}
		
//		Query query=session.createQuery("select sum(marks) from HqlDB where marks>60");
//		Long sum=(Long) query.uniqueResult();
//		System.out.println("sum is "+sum);
		
//-----------aggregate function distinct---------------------

//		Query query=session.createQuery("select distinct(marks) from HqlDB where marks>60");
//		List<Integer> distinct=(List<Integer>) query.list();
//		for(Integer hb:distinct) 
//		{
//		System.out.println(hb);
//		}
		
		
//		-----------------prepached statement-------------
//		int max =50;
//		
//		Query query=session.createQuery("select name,marks from HqlDB where marks>:max");
//		query.setParameter("max", max);
//		List<Object[]> list=(List<Object[]>) query.list(); 
//		
//		for(Object[] hb:list) {
//			System.out.println(hb[0]+" "+hb[1]);
//		}

		
//		---------------sql query in hibernate-----------
		Query query=session.createSQLQuery("select name,marks from HqlDB where marks<=30");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List std=query.list();
		for(Object o:std)
		{
			Map m=(Map)o;
			System.out.println(m.get("name")+"  :  "+m.get("marks"));
		}
		session.getTransaction().commit();
		session.close();
	}

}
