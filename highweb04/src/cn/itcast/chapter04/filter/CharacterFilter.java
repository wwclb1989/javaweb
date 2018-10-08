package cn.itcast.chapter04.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 拦截所有的请求，解决全站中文乱码
		// 指定request和response的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 在放行时，应该给目标资源一个request对象，让目标资源调用
		// getParameter时调到我们写的getParameter
		// 对request进行包装
//		CharacterRequest
		
		chain.doFilter(request, response);
	}


}

// 针对request对象进行包装
// 继承默认包装类HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper {

	public CharacterRequest(HttpServletRequest request) {
		super(request);
	}
	
	// 子类继承父类一定会覆写一些方法，此处用于重写getParameter()方法
	public String getParameter(String name) {
		// 调用被包装对象的getParameter()方法获得请求参数
		String value = super.getParameter(name);
		if (value == null) {
			return null;
		}
		// 判断请求方式
		String method = super.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 解决乱码后返回结果
		return value;
	}
}
