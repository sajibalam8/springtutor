package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name="USERS")
public class Users{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="PASSWORD")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//order by 3
	//limit
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}
