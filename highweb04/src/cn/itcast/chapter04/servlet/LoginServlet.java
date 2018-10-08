package cn.itcast.chapter04.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.chapter04.entity.User;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 检查用户名和密码
		if ("itcast".equals(username) && "123456".equals(password)) {
			// 登录成功
			// 将用户状态user对象存入session域
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			// 发送自动登录的cookie
			String autoLogin = request.getParameter("autoLogin");
			if (autoLogin != null) {
				// 注意cookie中的密码要加密
				Cookie cookie = new Cookie("autologin", username + "-" + password);
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
			// 跳转至首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			request.setAttribute("errerMsg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
