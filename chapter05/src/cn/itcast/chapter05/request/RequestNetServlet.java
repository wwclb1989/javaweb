package cn.itcast.chapter05.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestNetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//用于获取请求客户端的IP地址
		out.println("getRemoteAddr:" + request.getRemoteAddr() + "<br>");
		//用于获取请求客户端的完整主机名，如果无法解析出客户机的完整主机名，该方法将会返回客户端的IP地址
		out.println("getRemoteHost:" + request.getRemoteHost() + "<br>");
		//该方法用于获取请求客户端网络连接的端口号
		out.println("getRemotePort:" + request.getRemotePort() + "<br>");
		//获取Web服务器上接收当前请求网络连接的IP地址
		out.println("getLocalAddr:" + request.getLocalAddr() + "<br>");
		//获取Web服务器上接收当前网络连接IP所对应的主机名
		out.println("getLocalName:" + request.getLocalName() + "<br>");
		//获取Web服务器上接收当前网络连接的端口号
		out.println("getLocalPort:" + request.getLocalPort() + "<br>");
		//用于获取当前请求所指向的主机名,即HTTP请求消息中Host头字段所对应的主机名部分
		out.println("getServerName:" + request.getServerName() + "<br>"); 
		//用于获取当前请求所连接的服务器端口号,即HTTP请求消息中Host头字段所对应的端口号部分
		out.println("getServerPort:" + request.getServerPort() + "<br>");
		//用于获取请求的协议名
		out.println("getScheme:" + request.getScheme() + "<br>");
		//用于获取客户端发出请求时的完整URL
		out.println("getRequestURL:" + request.getRequestURL() + "<br>"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
