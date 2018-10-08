<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body style="text-align: center;">
	<a href="<%=request.getContextPath() %>/CharacterServlet?name=传智播客&password=123456">点击超链接登录</a>
	<form action="<%=request.getContextPath()%>/CharacterServlet" method="post">
		<table border="1" width="600px" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td height="30" align="center">用户名：</td>
				<td>&nbsp;<input type="text" name="name" /></td>
			</tr>
			<tr>
				<td height="30" align="center">密&nbsp;码：</td>
				<td>&nbsp;<input type="password" name="password" /></td>
			</tr>
			<tr>
				<td height="30" colspan="2" align="center">
					<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>