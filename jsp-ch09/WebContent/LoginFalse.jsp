<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="loginbean" type="mybean.mvc.loginBean"
 scope="session"/>
<html>
<head><title>这是登录失败页面</title>
</head>
<body bgcolor="#33CCFF">
 <font size="2">
  您登录的用户名是：
  <jsp:getProperty name="loginbean" property="name"/>
  <br>您输入的密码是：
  <jsp:getProperty name="loginbean" property="password"/>
  <br>您登录状态是：
  <jsp:getProperty name="loginbean" property="flag"/>
  <br><a href="Login.jsp" target="_self">返回登录界面：</a>
  </font>
</body>
</html>