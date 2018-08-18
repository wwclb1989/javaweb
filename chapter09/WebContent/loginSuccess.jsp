<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login successfully</title>
<style type="text/css">
	#main {
		width: 500px;
		height: auto;
	}
	#main div {
		width: 200px;
		height: auto;
	}
	ul {
		padding-top: 1px;
		padding-left: 1px;
		list-style: none;
	}
</style>
</head>
<body>
	<%
		if (session.getAttribute("userBean") == null) {
	%>
	<jsp:forward page="register.jsp" />
	<%
		return;
		}
	%>
	<jsp:useBean id="userBean" class="cn.itcast.chapter09.model2.domain.UserBean" scope="session" />
	<div id="welcome">恭喜你，登录成功</div>
	<hr />
	<div>您的信息</div>
	<div>
		<ul>
			<li>您的姓名：${userBean.name}</li>
			<li>您的邮箱：${userBean.email}</li>
		</ul>
	</div>
</body>
</html>