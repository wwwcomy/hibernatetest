package com.iteye.wwwcomy.simulation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.iteye.wwwcomy.model.Teacher;
import com.wwwcomy.iteye.bbs.db.DBManager;

/**
 * @author wwwcomy
 * 
 *         Hibernate大致原理
 */
public class MySession {

	Map<String, String> cols = new HashMap<String, String>();
	String tableName = "teacher";

	public MySession() {
		cols.put("id", "id");
		cols.put("name", "name");
		cols.put("title", "title");
	}

	public void save(Teacher t) throws Throwable {
		String sql = createSql(cols);
		System.out.println(sql);
		Connection conn = DBManager.getConn();
		PreparedStatement ps = DBManager.prepare(conn, sql);

		Set<String> set = cols.keySet();
		Class<? extends Teacher> clazz = t.getClass();
		int i = 1;
		for (String tmp : set) {
			String val = cols.get(tmp);
			// 把字段名转换为方法名
			Character c = Character.toUpperCase(val.charAt(0));
			Method m = clazz.getMethod("get" + c + val.substring(1));
			Class<?> type = m.getReturnType();
			String typeName = type.getName();

			// 判断字段类型用于设置不同类型的值到PreparedStatement中
			if (typeName.equalsIgnoreCase("java.lang.string")) {
				// 调用方法
				ps.setString(i, (String) m.invoke(t));
			} else if (typeName.equalsIgnoreCase("int")) {
				ps.setInt(i, (Integer) m.invoke(t));
			}
			i++;
			System.out.println(m.invoke(t));
			System.out.println(type);
		}
		{
			// System.out.println(clazz.getDeclaredField("id").getType().getName());
			// System.out.println(clazz.getDeclaredField("name").getType().getName());
			// System.out.println(clazz.getDeclaredField("title").getType().getName());
		}
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	private String createSql(Map<String, String> cols) {
		String keyStr = "";
		String valueStr = "";
		Set<String> s = cols.keySet();
		for (String tmp : s) {
			keyStr += tmp + ",";
			valueStr += "?,";
		}
		if (keyStr.length() > 0) {
			keyStr = keyStr.substring(0, keyStr.length() - 1);
			valueStr = valueStr.substring(0, valueStr.length() - 1);
		}
		String sql = "insert into " + tableName + "(" + keyStr + ") values (" + valueStr + ")";
		return sql;
	}
}
