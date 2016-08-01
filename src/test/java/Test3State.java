import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iteye.wwwcomy.model.Teacher;

public class Test3State {

	private static SessionFactory factory = null;

	@BeforeClass
	public static void beforeClass() {
		Configuration cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
	}

	// @Test
	public void testSave() {
		Teacher t = new Teacher();
		t.setTitle("高级教师1");
		t.setName("liuliu2");
		t.setBirthDay(new Date());

		Session session = factory.openSession();

		session.beginTransaction();
		session.save(t);
		System.out.println(t.getId());
		session.getTransaction().commit();
		session.close();
	}

	// @Test
	public void testDel() {
		Teacher t = new Teacher();
		// @NOTICE 这里如果不设置ID的话是删除不掉的
		t.setId(2);
		t.setTitle("高级教师1");
		t.setName("liuliu2");
		t.setBirthDay(new Date());

		Session session = factory.openSession();

		session.beginTransaction();
		session.delete(t);
		System.out.println(t.getId());
		session.getTransaction().commit();
		session.close();
	}

	// @Test
	public void testLoad() {

		Session session = factory.openSession();
		// session.beginTransaction();
		Teacher t = (Teacher) session.load(Teacher.class, 3);
		// 注意 这里输出的时候放到session close之后会报错
		// load方法使用的是动态代理方式，load时候并不会发送SQL请求，而是在使用这个对象的时候请求，采用的javassist
		System.out.println("testLoad" + t.toString());
		session.close();
	}

	// @Test
	public void testGet() {

		Session session = factory.openSession();
		// session.beginTransaction();
		Teacher t = (Teacher) session.get(Teacher.class, 3);
		session.close();
		System.out.println("testGet" + t.toString());
	}

	@Test
	public void testUpdate() {
		// 这里可以在同一个session，也可以搞两个session，注意写操作必须都得在transaction中
		// 如果在同一个session，也就是当teacher的状态是persistent的时候，这里改变他的属性，就会自动提交！！！
		// 所以同一个session不写update也会提交
		Session session = factory.openSession();
		session.beginTransaction();
		Teacher t = (Teacher) session.get(Teacher.class, 3);
		System.out.println("testGet" + t.toString());
		t.setName("wolegeca1");
		// session.update(t);
		session.getTransaction().commit();
		session.close();
	}

	// @Test
	public void testUpdate1() {

		Teacher t = new Teacher();
		t.setId(3);
		t.setTitle("ttt");
		t.setName("liuliu2");
		t.setBirthDay(new Date());

		Session session = factory.openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void afterClass() {
		factory.close();
	}
}
