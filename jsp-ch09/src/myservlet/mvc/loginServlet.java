package myservlet.mvc;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mybean.mvc.loginBean;
public class loginServlet extends HttpServlet{
	//1.����init����
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}
	
	//2.doPost����
	public void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException,IOException{
		HttpSession session = req.getSession(false);
		if (session == null) {//����ỰΪ�գ��ض��򵽴���ҳ��
			res.sendRedirect("http://localhost:8080/ch9/error.html");
		}
		loginBean lbean=null;
		lbean=getLBean(req);//�õ���¼bean
		session.setAttribute("loginbean", lbean);//��bean���浽session��
		if(lbean.isFlag()){//��¼�ɹ�ת��ҳ�浽LoginSuccess.jspҳ��
			//����bean���Ự��
	    	session.setAttribute("loginbean", lbean);
	    	String url="/LoginSuccess.jsp";
	    	ServletContext sc = getServletContext();
	    	RequestDispatcher rd = sc.getRequestDispatcher(url);
	    	rd.forward(req, res);
		}
		else{//��¼ʧ�ܣ��ض���LoginFailse.jspҳ��
			//����bean���Ự��
			session.setAttribute("loginbean", lbean);
			String url="LoginFalse.jsp";
            res.sendRedirect(url);
		}
    }
	
	//����Bean
	private loginBean getLBean(HttpServletRequest req) {
		//Ԥ���¼�û������ʻ�
		String loginNames[]={"yang","zhou","zhang","wang"};
		String passWords[]={"yang","zhou","zhang","wang"};
		//����bean
		loginBean lbean=new loginBean();
		String name=null;
		String password=null;
		name=(String)req.getParameter("loginname");
		if(name!=null){
			name=name.trim();//ȥ�ո�
			}
		password=(String)req.getParameter("password");
		if(password!=null){
			password=password.trim();//ȥ�ո�
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
