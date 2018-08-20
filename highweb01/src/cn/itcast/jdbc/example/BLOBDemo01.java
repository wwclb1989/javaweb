package cn.itcast.jdbc.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class BLOBDemo01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into testblob values(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 1);
			File file = new File("E:\\itcast.jpg");
			InputStream in = new FileInputStream(file);
			pst.setBinaryStream(2, in, (int) file.length());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pst, conn);
		}
	}

}
