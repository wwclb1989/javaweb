package cn.itcast.jdbc.example;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class CLOBDemo02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from testclob";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				Reader reader = rs.getCharacterStream("resume");
				Writer out = new FileWriter("E:\\resume.txt");
				int temp;
				while((temp=reader.read()) != -1) {
					System.out.println(temp);
					out.write(temp);
				}
				out.close();
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtils.release(pst, conn);
		}
	}

}
