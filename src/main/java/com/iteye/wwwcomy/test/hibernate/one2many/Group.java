package com.iteye.wwwcomy.test.hibernate.one2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author wwwcomy 一对多和多对一形成的数据库表结构是一样的 |单向关联
 */
@Entity
@Table(name = "t1_group")
public class Group {
	private int id;
	private String name;
	private Set<User> users = new HashSet<User>();

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

	// 如果不加JoinColumn Hibernate在处理一对多关系时会生成一张中间表用于创建连接
	@OneToMany
	@JoinColumn(name = "groupId")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
