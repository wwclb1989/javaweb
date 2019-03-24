<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>练习1</title>
<%!
	public int sum(int begin,int end){
		int sum=0;
		for(;begin<=end;begin++){
			sum+=begin;
		}
		return sum;
	}
%>
<!-- 程序加载时间<%=new java.util.Date().toLocaleString()%> -->
</head>
<body>
<h3>计算1-100的和:</h3>
<%--返回1-100的累加总和 --%>
<%=sum(1,100) %>
</body>
</html>