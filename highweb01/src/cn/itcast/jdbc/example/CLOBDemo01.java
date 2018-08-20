package cn.itcast.jdbc.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class CLOBDemo01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into testclob values(?,?)";
			pst = conn.prepareStatement(sql);
			File file = new File("E:\\itcast.txt");
			Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
			pst.setInt(1, 1);
			pst.setCharacterStream(2, reader, (int) file.length());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pst, conn);
		}
	}
}
