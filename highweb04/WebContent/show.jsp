<%@page import="cn.itcast.domain.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'show.jsp' starting page</title>
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>图书名称</th>
			<th>图书单价</th>
			<th>图书分类</th>
		</tr>
		<%
			List<Book> list = (List) request.getAttribute("bookList");
			for (Book b : list) {
		%>
		<tr>
			<td><%=b.getBname() %></td>
			<td><%=b.getPrice() %></td>
			<td>
				<% if (b.getCategory() == 1) { %>
				<p style="color:red;">JavaSE分类</p>
				<% } else if (b.getCategory() == 2) { %>
				<p style="color:blue;">JavaEE分类</p>
				<% } else { %>
				<p style="color:green;">Java框架分类</p>
				<% } %>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>