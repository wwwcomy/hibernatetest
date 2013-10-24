
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iteye.wwwcomy.util.HibernateUtil;

public class TestGenerate {

	public static void main(String[] args) throws Throwable {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.close();
	}

}
