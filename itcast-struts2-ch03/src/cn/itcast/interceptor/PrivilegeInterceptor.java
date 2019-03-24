package cn.itcast.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivilegeInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//得到ActionContext
		ActionContext context = ActionContext.getContext();
		//获取user对象
		Object user = context.getSession().get("user");
		if(user != null) {
			return invocation.invoke();			//继续向下执行
		} else {
			context.put("msg", "您还未登录,请先登录");
			return Action.LOGIN;
		}
	}

}
