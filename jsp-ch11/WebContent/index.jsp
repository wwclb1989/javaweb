<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>职称计算机考试报名</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上报名,职称考试,计算机"><!-- 为搜索引擎而准备 -->
	<meta http-equiv="description" content="网上报名首页">
	<link href="css/mystylesheet.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body class="twoColHybLtHdr">
    <div id="container">
      <div id="header">
         <%@ include file="txtfile/header.txt" %>
      </div>
      <div id="sidebar1">
         <%@ include file="txtfile/left.txt" %>        
      </div>
      <div id="mainContent">
          <center>
              <p><font size=4 color=red>欢迎您来报名！</font> </p><br>
              <img src="image/welcome.JPG" width=450 height=350></img>
          </center>
      </div>
      <br class="clearfloat" />
      <%@ include file="txtfile/footer.txt" %>
    </div>
  </body>
</html>  
