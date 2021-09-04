package com.example.demo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;

	private String email;

	private Date birthDay;

	private ESex sex;

	private String password;

	@OneToOne()
	@JoinColumn(name = "authority_id")
	private Authority authority;

	public User() {
	}

	public User(Long id, String userName, String email, Date birthDay, ESex sex, String password, Authority authority) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.birthDay = birthDay;
		this.sex = sex;
		this.password = password;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
