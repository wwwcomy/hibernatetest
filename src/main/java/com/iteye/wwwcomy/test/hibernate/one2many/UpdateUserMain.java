package com.iteye.wwwcomy.test.hibernate.one2many;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iteye.wwwcomy.util.HibernateUtil;

public class UpdateUserMain {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Query q = session.createQuery("from Group where id=1");
        Group g2 = (Group) q.uniqueResult();
        System.out.println(g2);
        Set<User> set = g2.getUsers();
        set.iterator().next().setName("u3_updated");
        set.add(new User(4, "u4"));
        Transaction txn = session.beginTransaction();
        session.saveOrUpdate(g2);
        txn.commit();
        session.flush();
        session.close();
        System.exit(0);
    }
}
