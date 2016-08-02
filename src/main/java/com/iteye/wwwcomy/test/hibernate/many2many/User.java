package com.iteye.wwwcomy.test.hibernate.many2many;

import javax.persistence.Column;
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

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@Column(name = "user_id")
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
