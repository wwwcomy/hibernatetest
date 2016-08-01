package com.iteye.wwwcomy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestTeacher {

	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setId(0);
		t.setTitle("高级教师");
		t.setName("liuliu");

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
