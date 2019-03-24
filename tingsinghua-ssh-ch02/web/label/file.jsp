<%-- 
    Document   : file
    Created on : 2017-9-24, 16:14:46
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>file标签的使用</title>
    </head>
    <body>
    <s:form>
        <s:file name="UploadFileName" accept="text/*" />
    </s:form>
    </body>
</html>
