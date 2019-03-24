package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class AwareAction extends ActionSupport implements ServletRequestAware {

	HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() throws Exception {
		request.setAttribute("message", "通过ServletRequestAware接口实现了访问Servlet API");
		return SUCCESS;
	}

}
