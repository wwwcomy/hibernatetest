package com.iteye.wwwcomy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "teacher1")
public class Teacher {

	private int id;
	private String title;
	private String name;
	private Date birthDay;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// GenerationType.IDENTITY(MySql,SQLServer)
	// GenerationType.SEQUENCE(ORCL)
	// ORCLE可以指定自己的Sequence，先定义SequenceGenerator：name,dbSEQName，然后在字段上使用这个SequenceGenerator即可。
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title1")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "ID:" + this.id + ",name:" + this.name + ",title:" + this.title + ",birthday:" + this.birthDay;
	}
}
