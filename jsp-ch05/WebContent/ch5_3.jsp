<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>例5.3 与表单参数值进行交互</title>
</head>
<body>
<form method="post" action="ch5_3_show.jsp" name="form1">
	<p>输入用户名称:
	<input type="text" name="loginName" size="20" />
	<br>输入用户密码:
	<input type="password" name="password" size="20" />
	<br>确认用户信息:&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="提交" size="6" />
	<input type="reset" name="reset" value="重置" size="6" />
</form>
</body>
</html>