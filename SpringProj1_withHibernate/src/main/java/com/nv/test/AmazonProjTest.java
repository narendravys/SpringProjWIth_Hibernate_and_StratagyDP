package com.nv.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nv.sbeans.Amazon;

public class AmazonProjTest {
	
	public static void main(String[] args) {
		// create IOC Container 
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nv/cfgs/applicationContext.xml");
		
		// getting object from IOC container
		Amazon amazon=ctx.getBean("amazon",Amazon.class);
		//calling business method
		String msg=amazon.addToCart(new String[] {"Laptop", "Mouse","Keyboard"},new double[] {92399.00,200.00,3400.00});
		System.out.println(msg);
		
		
		// creating hibernate session factory
		SessionFactory factory=new Configuration().configure("com/nv/cfgs/hibernate.cfg.xml").buildSessionFactory();
		// session
		Session session=factory.openSession();
		//begin transaction 
		Transaction txn= session.beginTransaction();
		session.save(amazon);
		txn.commit();
		session.close();
	}
	

}
