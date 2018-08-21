package cn.itcast.jdbc.example.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class ResultSetTest7 {

	public static void testColumnListHandler() {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user";
		List list = (List) basedao.query(sql, new ColumnListHandler("name"));
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		testColumnListHandler();
	}
}
