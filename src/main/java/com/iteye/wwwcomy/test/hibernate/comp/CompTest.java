package com.iteye.wwwcomy.test.hibernate.comp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iteye.wwwcomy.util.HibernateUtil;

public class CompTest {

	public static void main(String[] args) throws Throwable {
		Husband h = new Husband();
		h.setName("wangdalei");
		Wife w = new Wife();
		w.setWifeName("yezi");
		h.setWife(w);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
//		s.beginTransaction();
//		s.save(h);
//		s.getTransaction().commit();
		s.close();
	}

}
