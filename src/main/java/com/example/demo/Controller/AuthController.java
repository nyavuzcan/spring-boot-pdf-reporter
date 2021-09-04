package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.JwtResponse;
import com.example.demo.Dto.LoginRequest;
import com.example.demo.Dto.MessageResponse;
import com.example.demo.Dto.RegisterRequest;
import com.example.demo.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public MessageResponse register(@RequestBody RegisterRequest request) throws Exception {

		try {
			authService.checkEmailValid(request.getEmail());
		} catch (Exception e) {
			return new MessageResponse("email already taken");
		}
		try {
			authService.checkUserNameValid(request.getUserName());
		} catch (Exception e) {
			return new MessageResponse("username already taken");
		}

		authService.register(request);
		return new MessageResponse("Success");

	}

	@PostMapping("/login")
	private JwtResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
		return authService.login(loginRequest);

	}

}
