package com.iteye.wwwcomy.test.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iteye.wwwcomy.util.HibernateUtil;

public class one2one {

	public static void main(String[] args) throws Throwable {
		Husband h = new Husband();
		h.setName("wangdalei");
		Wife w = new Wife();
		w.setName("yezi");
		h.setWife(w);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(w);
		s.save(h);
		s.getTransaction().commit();
		s.close();
	}

}
