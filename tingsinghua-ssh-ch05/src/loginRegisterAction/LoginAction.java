package loginRegisterAction;

import java.util.List;
import loginRegisterDao.LoginRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;

import PO.UserInfoPO;

public class LoginAction extends ActionSupport{
	private String userName;
	private String password;
	private String message="error";
	private List list;
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
	public void validate(){
		if(this.getUserName()==null||this.getUserName().length()==0){
			//这句是什么意思?
			addFieldError("userName","用户名不能为空");
		}else{
			//数据库操作类
			LoginRegisterInfo info=new LoginRegisterInfo();
			list=info.queryInfo("username", this.getUserName());
			if(list.size()==0){
				addFieldError("userName","该用户尚未注册!");
			}else{
				UserInfoPO ui=new UserInfoPO();
				int count=0;
				for (int i = 0; i < list.size(); i++) {
					count++;
					ui=(UserInfoPO)list.get(i);
					if(this.getUserName().equals(ui.getUsername())){
						if(ui.getPassword().equals(this.getPassword())){
							message=SUCCESS;
						}else{
							addFieldError("password","登录密码不正确!");
						}
					}
				}
			}
		}
	}
	
	public String execute()throws Exception{
		//validate();
		return message;
	}
	
}
