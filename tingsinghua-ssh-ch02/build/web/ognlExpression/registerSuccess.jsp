<%-- 
    Document   : registerSuccess
    Created on : 2017-9-22, 20:23:58
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注册成功页面</title>
    </head>
    <body>
        <h1>${name}</h1>
        <hr>
        获取action属性:<s:property value="name" /><br>
        获取request属性:<s:property value="#request.name" /><br>
        获取session属性:<s:property value="#session.name" /><br>
        获取application属性:<s:property value="#application.name" /><br>
        <hr>
    </body>
</html>
