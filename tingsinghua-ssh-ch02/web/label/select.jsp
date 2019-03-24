<%-- 
    Document   : select
    Created on : 2017-9-24, 16:24:25
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>select标签的使用</title>
    </head>
    <body>
        <s:form>
            <s:select label="选择星期" headerValue="---请选择---" headerKey="3" list="{'星期一','星期二','星期三','星期四','星期五','星期六','星期日'}" />
        </s:form>
    </body>
</html>
