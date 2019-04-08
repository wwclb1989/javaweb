package com.itheima.autowire;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void save() {
		this.userService.save();
		System.out.println("userController...save...");
	}
	
}
