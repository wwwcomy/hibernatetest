package com.iteye.wwwcomy.test.hibernate.comp;

public class Wife {
	// 组合映射这里就不需要主键了
	// private int id;
	// 组合映射时，会存到一张表中，属性名注意不能重名
	private String wifeName;

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String name) {
		this.wifeName = name;
	}


}
