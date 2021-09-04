package com.example.demo.Dto;

import java.util.Date;
import com.example.demo.Entity.ESex;

public class RegisterRequest {

	private String userName;

	private String email;

	private Date birthDay;

	private ESex sex;

	private String password;

	
	public RegisterRequest() {
		
	}

	public RegisterRequest(String userName, String email, Date birthDay, ESex sex, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.birthDay = birthDay;
		this.sex = sex;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public ESex getSex() {
		return sex;
	}

	public void setSex(ESex sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
