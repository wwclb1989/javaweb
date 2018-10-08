package cn.itcast.chapter04.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter03 implements Filter {

	private String characterEncoding;
	FilterConfig fc;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		characterEncoding = fc.getInitParameter("encoding");
		System.out.println("encoding初始化参数的值为：" + characterEncoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fc = fConfig;
	}

}
