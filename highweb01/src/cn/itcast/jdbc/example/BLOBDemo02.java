package cn.itcast.jdbc.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class BLOBDemo02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from testblob where id=1";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				InputStream in = new BufferedInputStream(rs.getBinaryStream("img"));
				OutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\img.jpg"));
				int temp;
				while((temp=in.read()) != -1) {
					out.write(temp);
				}
				out.close();
				in.close();
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
