package com.model;

public class Person {
	private String username;
	private String password;
	private String name;
	private int role;
	private int classId;
	
	public Person() {
		super();
		this.role = -1;//表示当前实例不可用，登录失败
	}
	
	public Person(String username, String password, String name, int role, int classId) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.classId = classId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	
}
