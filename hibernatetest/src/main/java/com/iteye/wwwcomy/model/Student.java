package com.iteye.wwwcomy.model;

public class Student {
	private int id;
	private int age;
	private String name;
	private StudentIdcard studentIdcard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentIdcard getStudentIdcard() {
		return studentIdcard;
	}

	public void setStudentIdcard(StudentIdcard card) {
		this.studentIdcard = card;
	}
}
