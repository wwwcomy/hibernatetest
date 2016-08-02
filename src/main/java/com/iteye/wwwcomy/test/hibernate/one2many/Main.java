package com.iteye.wwwcomy.test.hibernate.one2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iteye.wwwcomy.util.HibernateUtil;

/**
 * Many-to-many test case, notice that the orphan records cannot be removed in a
 * many-to-one or a many-to-many mapping, it can only be used in a one-to-many
 * mapping.
 * 
 * @author wwwcomy
 *
 */
public class Main {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Group g1 = new Group("g1");
		User u1 = new User(1, "u1");
		User u2 = new User(2, "u2");
		Set<User> users = new HashSet<User>();
		users.add(u1);
		users.add(u2);
		g1.setUsers(users);

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(g1);
		txn.commit();
		session.flush();
		session.close();

		session = factory.openSession();
		Query q = session.createQuery("from Group where id=1");
		Group g2 = (Group) q.uniqueResult();
		System.out.println(g2);
		Set<User> set = g2.getUsers();
		set.clear();
		set.add(new User(3, "u3"));
		txn = session.beginTransaction();
		session.saveOrUpdate(g2);
		txn.commit();
		session.flush();
		session.close();
		System.exit(0);

	}
}
