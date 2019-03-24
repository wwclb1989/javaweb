<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>例7.10 使用连接池示例</title>
</head>
<body bgcolor="cyan">
<%
Connection conn;
Statement stmt;
ResultSet rs;
Context ctx=new InitialContext();
DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dataBook");
conn=ds.getConnection();
stmt=conn.createStatement();
rs=stmt.executeQuery("select * from book");
out.print("<table border=2>");
out.print("<tr>");
	out.print("<th width=50>"+"书号");
	out.print("<th width=100>"+"书名");
	out.print("<th width=50>"+"作者");
	out.print("<th width=100>"+"出版社");
	out.print("<th width=50>"+"单价");
out.print("</tr>");
while(rs.next()){
out.print("<tr>");
	out.print("<td>"+rs.getString(1)+"</td>");
	out.print("<td>"+rs.getString(2)+"</td>");
	out.print("<td>"+rs.getString(3)+"</td>");
	out.print("<td>"+rs.getString("publish")+"</td>");
	out.print("<td>"+rs.getString("price")+"</td>");
out.print("</tr>");
}
out.print("</table>");
rs.close();
stmt.close();
conn.close();
	
%>
</body>
</html>