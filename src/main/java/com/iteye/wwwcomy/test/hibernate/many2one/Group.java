package com.iteye.wwwcomy.test.hibernate.many2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wwwcomy 一对多和多对一形成的数据库表结构是一样的
 */
@Entity
@Table(name = "t_group")
public class Group {
	private int id;
	private String name;

	@Id
	@GeneratedValue
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
}
