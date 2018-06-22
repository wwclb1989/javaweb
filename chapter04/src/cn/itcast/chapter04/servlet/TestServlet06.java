package cn.itcast.chapter04.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = this.getServletContext();
		PrintWriter out = response.getWriter();
//		InputStream in = context.getResourceAsStream("/WEB-INF/classes/itcast.properties");
		String path = context.getRealPath("/WEB-INF/classes/itcast.properties");
		InputStream in = new FileInputStream(path);
		Properties pros = new Properties();
		pros.load(in);
		out.println("Company=" + pros.getProperty("Company") + "<br>");
		out.println("Address=" + pros.getProperty("Address") + "<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
