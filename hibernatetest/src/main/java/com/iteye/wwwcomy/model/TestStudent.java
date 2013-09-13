package com.iteye.wwwcomy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestStudent {

	public static void main(String[] args) {
		Student s = new Student();
		s.setId(12);
		s.setAge(20);
		s.setName("lilei0");

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		// 如果有session，就拿已经存在的session
		// Session session =factory.getCurrentSession();

		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
