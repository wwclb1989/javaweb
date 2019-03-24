<%-- 
    Document   : combobox
    Created on : 2017-9-24, 14:04:26
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>combobox标签的使用</title>
    </head>
    <body>
        <s:form>
            <s:combobox label="颜色选择" name="colorName" readonly="false" headerValue="---请选择---" headerKey="1" list="{'红色','蓝色','黑色','白色'}" />
        </s:form>
    </body>
</html>
