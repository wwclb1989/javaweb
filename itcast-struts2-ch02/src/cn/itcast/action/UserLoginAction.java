package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.User;

public class UserLoginAction extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		if("itcast".equals(user.getUsername())&&"123".equals(user.getPassword())) {
			context.getSession().put("username", user.getUsername());
			context.getSession().put("password", user.getPassword());
			return SUCCESS;
		} else {
			context.getSession().put("error", "用户登录失败!");
			return ERROR;
		}
	}
}
