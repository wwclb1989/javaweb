package com.itheima.assemble;

import java.util.List;

public class User {

	private String username;
	
	private String password;
	
	private List<String> list;

	public User(String username, String password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.list = list;
	}

	public User() {
		super();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", list=" + list + "]";
	}
	
}
