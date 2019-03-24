<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="基于SH的登录和注册系统"></s:text></title>
</head>
<body bgcolor="#CCCCFF">
	<s:form action="login" method="post">
		<br><br><br><br><br><br>
		<table border="1" align="center" bgcolor="#AABBCCDD">
			<tr>
				<td>
					<s:textfield name="userName" label="用户名字" size="16" />
				</td>
			</tr>
			<tr>
				<td>
					<s:password name="password" label="用户密码" size="18" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<s:submit value="登录" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:a href="http://localhost:8080/ssh-ch05/register.jsp">注册</s:a>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>