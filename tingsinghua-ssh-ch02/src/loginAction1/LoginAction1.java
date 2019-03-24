package loginAction1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction1 extends ActionSupport{
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception{
		if(getUserName().equals("QQ")&&getPassword().equals("123")){
			ActionContext ac=ActionContext.getContext();
			ac.getApplication().put("userName",getUserName());
			ac.getSession().put("userName", getUserName());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
