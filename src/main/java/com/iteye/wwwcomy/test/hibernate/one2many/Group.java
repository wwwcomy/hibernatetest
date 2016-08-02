package com.iteye.wwwcomy.test.hibernate.one2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author wwwcomy 一对多和多对一形成的数据库表结构是一样的 |单向关联
 */
@Entity
@Table(name = "t1_group")
public class Group {
	private int id;
	private String name;
	private Set<User> users = new HashSet<User>();

	public Group() {
	}

	public Group(String string) {
		this.name = string;
	}

	@Id
	@GeneratedValue
	@Column(name = "group_id")
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
	// Must add orphanRemoval = true to remove the orphan user records, so that
	// hibernate would not set the group_id value to null
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "group_id")
	@Cascade(value = { CascadeType.ALL })
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "group_id:" + id + ",name:" + name;
	}
}
