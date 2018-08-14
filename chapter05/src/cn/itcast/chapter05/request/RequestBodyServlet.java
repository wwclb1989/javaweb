package cn.itcast.chapter05.request;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestBodyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		InputStream in = request.getInputStream();
		byte[] buffer = new byte[1024];
		StringBuilder sb = new StringBuilder();
		int len;
		while ((len = in.read(buffer)) != -1) {
			sb.append(new String(buffer, 0, len));
		}
		System.out.println(sb);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
