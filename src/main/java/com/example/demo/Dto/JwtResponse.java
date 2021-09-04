package com.example.demo.Dto;

import java.io.Serializable;

import com.example.demo.Entity.User;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -7091479091924046844L;
    private final String token;
    private  User user;

    public JwtResponse(String token, User user) {
        this.token = token;
        this.user = user;
        this.user.setPassword("");
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getToken() {
		return token;
	}

    
}