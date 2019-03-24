<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.maths.MyRectangle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>例5.1 一个bean的示例</title>
</head>
<body bgcolor="cyan">
<jsp:useBean id="myrectangle" class="mybean.maths.MyRectangle" scope="page" />
<%
	//设置长
	myrectangle.setLength(2);
	//设置矩形宽
	myrectangle.setWidth(4);
%>
<p>getProperty动作输出矩形的面积是:
<jsp:getProperty name="myrectangle" property="area" />
<p>表达式输出矩形的面积是:
<%= myrectangle.getArea() %>
</body>
</html>