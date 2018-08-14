package cn.itcast.chapter05.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//获取请求消息中所有头字段
		Enumeration headerNames = request.getHeaderNames();
		//使用循环遍历所有请求头,并通过getHeader()方法获取一个指定名称的头字段
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.println(headerName + ":" + request.getHeader(headerName));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
