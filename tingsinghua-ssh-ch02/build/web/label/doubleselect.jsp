<%-- 
    Document   : doubleselect
    Created on : 2017-9-24, 14:10:36
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>doubleselect标签的使用</title>
    </head>
    <body>
        <s:form>
            <s:doubleselect label="选择一项" headerValue="---请选择---"
                            headerKey="1" doubleName="doublesel" list="{'颜色','水果'}"
                            doubleList="top=='颜色'?{'红色','蓝色','黑色','白色'}:{'苹果','香蕉','梨','葡萄'}" />
        </s:form>
    </body>
</html>
