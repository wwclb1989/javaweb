/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionerrorAndactionmessage;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author ★天命之子★
 */
public class ActionErrorActionMessage extends ActionSupport{
    public String execute(){
        //使用addActionError()方法添加信息
        addActionError("使用ActionError添加错误信息!");
        addActionMessage("使用ActionMessage添加普通信息!");
        return SUCCESS;
    }
}
