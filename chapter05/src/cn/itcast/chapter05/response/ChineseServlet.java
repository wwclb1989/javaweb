package cn.itcast.chapter05.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChineseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码格式
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String data = "中国";
		PrintWriter out = response.getWriter();
		out.write(data);
		//第一种解决方式
		//设置HttpServletResponse使用utf-8编码
		//response.setCharacterEncoding("utf-8");
		//通知浏览器使用utf-8解码
		//response.setHeader("Content-Type", "text/html;charset=utf8");
		//第二种方式
		//包含第一种方式的两个功能
		//response.setContentType("text/html;charset=utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
