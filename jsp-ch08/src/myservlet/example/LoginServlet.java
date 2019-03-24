package myservlet.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet示例
 * @author ★天命之子★
 *一般编写一个Servlet类首先要引入java.io包,javax.servlet包,和javax.servlet.http包,
 *然后就是编写一个HttpServlet类的子类,这个子类重载了HttpServlet父类GenericServlet的init方法
 *和service方法
 */
//1.继承HttpServlet类
public class LoginServlet extends HttpServlet{

	String name;
	String password;
	
	//2.重载init方法
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	
	//3.doPost
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		name=request.getParameter("name");
		password=request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
		//获取输出流对象
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>获得表单参数</title></head>");
		out.println("<body>");
		out.println("<h3>您输入的参数是：</h3>");
		out.println("<li>用户名（name）："+name);
		out.println("<li>用户密码（password）："+password);
		out.println("</body></html>");	
	}
}
