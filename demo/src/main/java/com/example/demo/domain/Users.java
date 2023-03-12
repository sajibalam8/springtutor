package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Users{
	
	@Id
	private int id;
	private String userpaName;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserpaName() {
		return userpaName;
	}
	public void setUserpaName(String userpaName) {
		this.userpaName = userpaName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userpaName=" + userpaName + ", password=" + password + "]";
	}
	
	
	
	
	

}
