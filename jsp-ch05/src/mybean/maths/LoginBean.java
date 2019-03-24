package mybean.maths;

public class LoginBean {

	private String loginName=null;
	private String password=null;
	
	public LoginBean(){
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean check(){
		if("yang".equals(loginName)&&"yang".equals(password)){
			return true;
		}else{
			return false;
		}
	}
}
