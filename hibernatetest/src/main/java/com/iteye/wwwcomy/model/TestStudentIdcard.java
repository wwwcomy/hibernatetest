package com.iteye.wwwcomy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestStudentIdcard {
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(12);
		s.setAge(20);
		s.setName("lilei0");
		
		StudentIdcard card = new StudentIdcard();
		card.setId(1);
		card.setStudent(s);
		s.setStudentIdcard(card);

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
