<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><body bgcolor=cyan>
<form action="helpLogin" method="post">
  <table width="366" border="1" cellspacing="2" cellpadding="2">
    <tr>
      <th colspan="3" scope="col">用户登录</th>
    </tr>
    <tr>
      <td width="48" rowspan="3">这是一个演示登录程序</td>
      <td width="102">用户名：</td>
      <td width="222"><label>
        <input type="text" name="name" id="name">
      </label></td>
    </tr>
    <tr>
      <td>用户密码：</td>
      <td><label>
        <input type="text" name="password" id="password">
      </label></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="g" value="提交">
      <label>
      <input type="reset" name="reset" id="reset" value="重置">
      </label></td>
    </tr>
  </table>
</form>
</body></html>