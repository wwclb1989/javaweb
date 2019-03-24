package myservlet.mvc;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mybean.mvc.loginBean;
public class loginServlet extends HttpServlet{
	//1.重载init方法
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}
	
	//2.doPost方法
	public void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException,IOException{
		HttpSession session = req.getSession(false);
		if (session == null) {//如果会话为空，重定向到错误页面
			res.sendRedirect("http://localhost:8080/ch9/error.html");
		}
		loginBean lbean=null;
		lbean=getLBean(req);//得到登录bean
		session.setAttribute("loginbean", lbean);//将bean保存到session中
		if(lbean.isFlag()){//登录成功转发页面到LoginSuccess.jsp页面
			//保存bean到会话中
	    	session.setAttribute("loginbean", lbean);
	    	String url="/LoginSuccess.jsp";
	    	ServletContext sc = getServletContext();
	    	RequestDispatcher rd = sc.getRequestDispatcher(url);
	    	rd.forward(req, res);
		}
		else{//登录失败，重定向到LoginFailse.jsp页面
			//保存bean到会话中
			session.setAttribute("loginbean", lbean);
			String url="LoginFalse.jsp";
            res.sendRedirect(url);
		}
    }
	
	//调用Bean
	private loginBean getLBean(HttpServletRequest req) {
		//预设登录用户名和帐户
		String loginNames[]={"yang","zhou","zhang","wang"};
		String passWords[]={"yang","zhou","zhang","wang"};
		//创建bean
		loginBean lbean=new loginBean();
		String name=null;
		String password=null;
		name=(String)req.getParameter("loginname");
		if(name!=null){
			name=name.trim();//去空格
			}
		password=(String)req.getParameter("password");
		if(password!=null){
			password=password.trim();//去空格
		}
		for(int i=0;i<4;i++){
			if(loginNames[i].equals(name)&&
					passWords[i].equals(password))
			{
				lbean.setFlag(true);
				break;
			}
		}
		lbean.setName(name);
		lbean.setPassword(password);		
		return lbean;
	}
}
