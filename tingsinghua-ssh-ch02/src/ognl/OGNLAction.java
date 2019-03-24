/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ognl;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author ★天命之子★
 */
public class OGNLAction extends ActionSupport{
    private String no;
    private String name;
    private String sex;
    private int age;

    /**
     * @return the no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    public String execute() throws Exception{
        //获取request,并添加信息
        HttpServletRequest request=ServletActionContext.getRequest();
        request.setAttribute("name",getName());
        //获取session,并添加信息
        Map session=ActionContext.getContext().getSession();
        session.put("name",getName());
        //获取application,并添加信息
        Map application=ActionContext.getContext().getApplication();
        application.put("name", getName());
        return SUCCESS;
    }
}
