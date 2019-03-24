<%-- 
    Document   : success1
    Created on : 2017-9-11, 18:36:22
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="登录成功页面"/></title>
    </head>
    <body>
        获取application中的信息:欢迎<s:property value="#application.userName"/>
    <br/>
        获取session中的信息:欢迎<s:property value="#session.userName"/>
    </body>
</html>
