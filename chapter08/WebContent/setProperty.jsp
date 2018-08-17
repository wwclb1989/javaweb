<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.itcast.chapter08.javabean.Manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		公司<input type="text" name="corp"> <br>
		资金<input type="text" name="reward"> <br>
		<input type="submit" value="提交">
	</form>
	<jsp:useBean id="manager" class="cn.itcast.chapter08.javabean.Manager" />
	<jsp:setProperty property="company" param="corp" name="manager"/>
	<jsp:setProperty property="bonus" param="reward" name="manager"/>
	<%
		manager = (Manager) pageContext.getAttribute("manager");
		out.write("bonus属性的值为:" + manager.getBonus() + "<br />");
		out.write("company属性的值为:" + manager.getCompany());
	%>
</body>
</html>