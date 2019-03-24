<%-- 
    Document   : optiontransferselect
    Created on : 2017-9-24, 16:28:42
    Author     : ★天命之子★
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>optiontransferselect标签的使用</title>
    </head>
    <body>
        <s:form>
            <s:optiontransferselect label="你喜欢的城市" name="left" leftTitle="国内"
              rightTitle="国外" list="{'北京','上海','南京','深圳','海南','青岛'}"
              headerValue="---请选择---" doubleHeaderKey="1" doubleName="right"
              doubleList="{'东京','华盛顿','伦敦','芝加哥','温哥华','多伦多'}" />
        </s:form>
    </body>
</html>
