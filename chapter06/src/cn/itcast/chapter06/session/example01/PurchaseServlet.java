package cn.itcast.chapter06.session.example01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//如果id为null,重定向到ListBookServlet页面
		if (id == null) {
			String url = "/chapter06/ListBookServlet";
			response.sendRedirect(url);
			return;
		}
		Book book = BookDB.getBook(id);
		//创建或者获得用户的session对象
		HttpSession session = request.getSession();
		//从session对象名获得用户的购物车
		List<Book> cart = (List) session.getAttribute("cart");
		if (cart == null) {
			//首次购买,为用户创建一个购物车(List集合)
			cart = new ArrayList<>();
			//将购物车存入session对象
			session.setAttribute("cart", cart);
		}
		//将商品放入购物车
		cart.add(book);
		//创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/chapter06");
		response.addCookie(cookie);
		//重定向到购物车页面
		String url = "/chapter06/CartServlet";
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
