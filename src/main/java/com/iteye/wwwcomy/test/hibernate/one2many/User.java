package com.iteye.wwwcomy.test.hibernate.one2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t1_user")
public class User {
	private int id;
	private String name;

	public User() {
	}

	public User(int id, String string) {
		this.id = id;
		this.name = string;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "user_id:" + id + ",name:" + name;
	}
}
