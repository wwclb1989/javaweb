package myservlet.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servletʾ��
 * @author ������֮�ӡ�
 *һ���дһ��Servlet������Ҫ����java.io��,javax.servlet��,��javax.servlet.http��,
 *Ȼ����Ǳ�дһ��HttpServlet�������,�������������HttpServlet����GenericServlet��init����
 *��service����
 */
//1.�̳�HttpServlet��
public class LoginServlet extends HttpServlet{

	String name;
	String password;
	
	//2.����init����
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	
	//3.doPost
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		name=request.getParameter("name");
		password=request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
		//��ȡ���������
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>��ñ�����</title></head>");
		out.println("<body>");
		out.println("<h3>������Ĳ����ǣ�</h3>");
		out.println("<li>�û�����name����"+name);
		out.println("<li>�û����루password����"+password);
		out.println("</body></html>");	
	}
}
