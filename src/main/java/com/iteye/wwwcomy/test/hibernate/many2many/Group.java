package com.iteye.wwwcomy.test.hibernate.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t1_group")
public class Group {
	private int id;
	private String name;
	private Set<User> users = new HashSet<User>();

	public Group() {
	}

	public Group(String name) {
		this.name = name;
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

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = User.class)
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
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
