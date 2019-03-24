<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.maths.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>例5.2 setProperty动作指令示例</title>
</head>
<body bgcolor="cyan">
<jsp:useBean id="stu" class="mybean.maths.Student" scope="page"/>
<%
	long number=12345;
%>
<jsp:setProperty name="stu" property="name" value="杨得力" />
<jsp:setProperty name="stu" property="sex" value="男" />
<jsp:setProperty name="stu" property="number" value="<%=number %>" />
<jsp:setProperty name="stu" property="height" value="<%=170 %>" />
<jsp:setProperty name="stu" property="weight" value="80" />
<p>getProperty动作指令输出学生信息:
<br>学生姓名:
<jsp:getProperty name="stu" property="name" />
<br>学生性别:
<jsp:getProperty name="stu" property="sex" />
<br>学生学号:
<jsp:getProperty name="stu" property="number" />
<br>学生身高:
<jsp:getProperty name="stu" property="height" />
<br>学生体重:
<jsp:getProperty property="weight" name="stu"/>
</body>
</html>