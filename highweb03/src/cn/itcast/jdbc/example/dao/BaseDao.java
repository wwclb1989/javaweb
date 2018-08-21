package cn.itcast.jdbc.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import cn.itcast.jdbc.utils.JDBCUtils1;

public class BaseDao {

	public static Object query(String sql, ResultSetHandler<?> rsh, Object...params) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils1.getConnection();
			pst = conn.prepareStatement(sql);
			for (int i = 0; params != null && i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
			rs = pst.executeQuery();
			//让调用者去实现对结果集的处理
			Object obj = rsh.handle(rs);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils1.release(rs, pst, conn);
		}
		return rs;
	}
}
