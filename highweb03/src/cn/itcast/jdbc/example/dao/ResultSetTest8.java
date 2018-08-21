package cn.itcast.jdbc.example.dao;

import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ResultSetTest8 {

	public static void testScalarHandler() {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user where id=?";
		Object arr = basedao.query(sql, new ScalarHandler("name"), 1);
		System.out.println(arr);
	}
	
	public static void main(String[] args) {
		testScalarHandler();
	}
}
