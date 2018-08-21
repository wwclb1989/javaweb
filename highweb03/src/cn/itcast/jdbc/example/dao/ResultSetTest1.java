package cn.itcast.jdbc.example.dao;

import org.apache.commons.dbutils.handlers.ArrayHandler;

public class ResultSetTest1 {

	public static void testArrayHandler() {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user where id=?";
		Object[] arr = (Object[]) basedao.query(sql, new ArrayHandler(), new Object[]{1});
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	public static void main(String[] args) {
		testArrayHandler();
	}
}
