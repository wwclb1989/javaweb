package cn.itcast.chapter05.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取请求行的相关信息
		out.println("getMethod:" + request.getMethod() + "<br>");
		out.println("getRequestURI:" + request.getRequestURI() + "<br>");
		out.println("getQueryString:" + request.getQueryString() + "<br>");
		out.println("getProtocol:" + request.getProtocol() + "<br>");
		out.println("getContextPath:" + request.getContextPath() + "<br>");
		out.println("getPathInfo:" + request.getPathInfo() + "<br>");
		out.println("getPathTranslated:" + request.getPathTranslated() + "<br>");
		out.println("getServletPath:" + request.getServletPath() + "<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
