package cn.itcast.chapter06.session.example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//变量cart引用用户的购物车
		List<Book> cart = null;
		//变量PruFlag标记用户是否买过商品
		boolean purFlag = true;
		//获得用户的session
		HttpSession session = request.getSession(false);
		if (session == null) {
			purFlag = false;
		} else {
			//获得用户购物车
			cart = (List) session.getAttribute("cart");
			//如果用户的购物车为null,purFlag置为false
			if (cart == null) {
				purFlag = false;
			}
		}
		
		if (!purFlag) {
			out.write("对不起!您还没有购买任何商品!<br>");
		} else {
			//否则显示用户购买图书的信息
			out.write("您购买的图书有:<br>");
			double price = 0;
			for (Book book : cart) {
				out.write(book.getName() + "<br>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
