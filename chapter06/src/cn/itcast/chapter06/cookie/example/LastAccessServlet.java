package cn.itcast.chapter06.cookie.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		
		if (lastAccessTime == null) {
			response.getWriter().print("您是首次访问本站");
		} else {
			response.getWriter().print("您上次的访问时间是:" + lastAccessTime);
		}
		
		String currenttime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		Cookie cookie = new Cookie("lastAccess", currenttime);
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
