package cn.itcast.chapter04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestServlet02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//获得ServletConfig对象
		ServletConfig config = this.getServletConfig();
		//获得参数名为encoding对应的参数值
		String param = config.getInitParameter("encoding");
		out.println("encoding=" + param);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
