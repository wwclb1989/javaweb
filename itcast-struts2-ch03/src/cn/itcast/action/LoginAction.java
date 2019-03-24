package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}

	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		if("tom".equals(user.getUsername())&&"123".equals(user.getPassword())) {
			context.getSession().put("user", user);
			return SUCCESS;
		} else {
			context.put("msg", "用户名或密码不正确");
			return INPUT;
		}
	}
}
