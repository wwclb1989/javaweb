package mybean.maths;

import java.util.ArrayList;

class chString{
	public String handleString(String s){
		String str=s;
		try{
			byte b[]=str.getBytes("ISO-8859-1");
			str=new String(b);
		}
		catch(Exception e){}
		return str;
	}
}

class message{
	String title=null;
	String author=null;
	String mess=null;
	long num;
	//chString chstr=new chString();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
}

public class messList {

	ArrayList<message> messL=null;
	long number;
	public messList(){
		messL=new ArrayList<message>();
		number=0;
	}
	
	synchronized public void add(String author,String title,String mess){
		if(!("".equals(author))||"".equals(title)||"".equals(mess)){
			number++;
			message mtemp=new message();
			mtemp.setAuthor(author);
			mtemp.setMess(mess);
			mtemp.setTitle(title);
			mtemp.setNum(number);
			messL.add(mtemp);
			
		}
	}
	
	public StringBuffer getMessSet(){
		StringBuffer strWatch=new StringBuffer();
		for(message me:messL){
			strWatch.append("<br>");
			strWatch.append("No:"+me.getNum());
			strWatch.append("<br>���⣺");
			strWatch.append(me.getTitle());
			strWatch.append("<br>������");
			strWatch.append(me.getAuthor());
			strWatch.append("<br>���ݣ�<br>");
			strWatch.append(me.getMess()+"<br>");
		}
		return strWatch;
	}
}
