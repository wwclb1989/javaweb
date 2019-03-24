<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="登录成功页面" /></title>
</head>
<body>
<!-- OGNL表达式和标签库的使用,value的值为OGNL表达式 -->
获取application中的信息:欢迎<s:property value="#application.userName" />
<br/>
获取seession中的信息:cqqb<s:property value="#session.userName" />
</body>
</html>