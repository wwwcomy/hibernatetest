import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iteye.wwwcomy.model.Teacher;

public class TestTeacher1 {

	private static SessionFactory factory = null;

	@BeforeClass
	public static void beforeClass() {
		Configuration cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
	}

	@Test
	public void testSave() {
		Teacher t = new Teacher();
		t.setTitle("高级教师");
		t.setName("liuliu1");
		t.setBirthDay(new Date());

		Session session = factory.openSession();
		Session session1 = factory.getCurrentSession();
		// 一般来说openSession和getCurrentSession不能混用  没有实际意义
		System.out.println("***" + (session == session1));

		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void afterClass() {
		factory.close();
	}
}
