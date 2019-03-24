<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<html><body bgcolor=cyan>
<%!
  public String getString(String s){
	String str=s;
	try{byte bb[]=str.getBytes("ISO-8859-1");
	    str=new String(bb);
	}
	catch(Exception e){}
	return str;
  }
%>
<% Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;
   try{ Class.forName("oracle.jdbc.driver.OracleDriver");	   
   }
   catch(ClassNotFoundException e)
   {
	   out.print(e);
   }
   try{ //和数据库建立连接
       conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tecmo","tecmo");
       stmt=conn.createStatement(); //创建Statement对象，用于执行SQL语句
       rs=stmt.executeQuery("select * from book");
       out.print("<table border=2>");
       out.print("<tr>");
         out.print("<th width=50>"+"书号");
         out.print("<th width=100>"+"书名");
         out.print("<th width=50>"+"作者");
         out.print("<th width=100>"+"出版社");
         out.print("<th width=50>"+"单价");
       out.print("</tr>");
       while(rs.next()){
    	   out.print("<tr>");
    	     out.print("<td>"+getString(rs.getString(1))+"</td>");
    	     out.print("<td>"+getString(rs.getString(2))+"</td>");
    	     out.print("<td>"+getString(rs.getString(3))+"</td>");
    	     out.print("<td>"+getString(rs.getString("publish"))+"</td>");
    	     out.print("<td>"+rs.getFloat("price")+"</td>");
    	   out.print("</tr>");
       }
       out.print("</table>");       
       stmt.close();  //关闭数据库
       conn.close();
   }
   catch(Exception e)
   {
       out.println(e.toString());
   }
%></body></html>