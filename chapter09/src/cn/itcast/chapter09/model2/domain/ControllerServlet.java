package cn.itcast.chapter09.model2.domain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//原始页面编码是utf-8,因此需要设置请求解码为utf-8
		request.setCharacterEncoding("utf-8");
		//通知浏览器使用utf-8解码
		//		response.setHeader("Content-type", "text/html;charset=utf-8");
		//设置响应编码
//		response.setCharacterEncoding("utf-8");
		//设置响应编码，同时通知浏览器使用utf-8解码
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setName(name);
		formBean.setPassword(password);
		formBean.setPassword2(password2);
		formBean.setEmail(email);
		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		UserBean userBean = new UserBean();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		boolean b = DBUtil.getInstance().insertUser(userBean);
		if (!b) {
			request.setAttribute("DBMes", "你注册的用户已存在");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		response.getWriter().print("恭喜你注册成功,3秒种自动跳转");
		request.getSession().setAttribute("userBean", userBean);
		response.setHeader("refresh", "3;url=loginSuccess.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
