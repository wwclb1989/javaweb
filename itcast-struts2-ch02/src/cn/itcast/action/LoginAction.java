package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		if("itcast".equals(username)&&"123".equals(password)) {
			context.put("username", username);
			context.put("password", password);
			context.put("success", "用户登录成功");
			return SUCCESS;
		} else {
			context.put("error", "用户登录失败");
			return ERROR;
		}
	}
}
