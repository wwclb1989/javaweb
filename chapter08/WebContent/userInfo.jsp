<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="user" class="cn.itcast.chapter08.javabean.User" />
	<jsp:setProperty property="*" name="user"/>
	<jsp:setProperty property="email" param="mail" name="user"/>
	姓名:<jsp:getProperty property="name" name="user"/> <br/>
	性别:<jsp:getProperty property="gender" name="user"/> <br/>
	学历:<jsp:getProperty property="education" name="user"/> <br/>
	邮箱:<jsp:getProperty property="email" name="user"/> <br/>
</body>
</html>