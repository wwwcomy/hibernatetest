package com.iteye.wwwcomy.simulation;

import com.iteye.wwwcomy.model.Teacher;

public class MyTest {

	public static void main(String[] args) throws Throwable {
		Teacher t = new Teacher();
		t.setId(0);
		t.setTitle("高级教师a ");
		t.setName("米丝蒂");

		MySession session = new MySession();
		session.save(t);

	}

}
