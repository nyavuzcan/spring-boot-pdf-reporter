package com.example.demo.Service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Configuration.JwtTokenUtil;
import com.example.demo.Dto.JwtResponse;
import com.example.demo.Dto.LoginRequest;
import com.example.demo.Dto.RegisterRequest;
import com.example.demo.Entity.Authority;
import com.example.demo.Entity.ERole;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	public void register(RegisterRequest request) throws Exception {
		if (checkEmailValid(request.getEmail()) && checkUserNameValid(request.getUserName())) {

			Authority authority = null;
			Optional<Authority> op = authorityService.findByAuthority(ERole.ROLE_USER);

			if (op.isPresent()) {
				authority = op.get();
			} else {
				authority = authorityService.save(new Authority(ERole.ROLE_USER));
			}
			User user=new User();
			user.setUserName(request.getUserName());
			user.setEmail(request.getEmail());
			user.setBirthDay(request.getBirthDay());
			user.setSex(request.getSex());
			user.setAuthority(authority);
			user.setPassword(encoder.encode(request.getPassword()));
			userRepository.save(user);
		}
	}

	public Optional<User> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public boolean checkUserNameValid(String userName) throws Exception {
		Optional<User> op = userRepository.findByUserName(userName);

		if (op.isPresent()) {
			throw new Exception("username already taken");
		}
		return true;
	}

	public boolean checkEmailValid(String email) throws Exception {
		Optional<User> op = userRepository.findByEmail(email);

		if (op.isPresent()) {
			throw new Exception("email already taken");
		}
		return true;
	}

	public JwtResponse login(LoginRequest request) throws Exception {

		authenticate(request.getUsername(), request.getPassword());
		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return getUserWithJwtToken(userDetails.getUsername(), token);

	}

	private void authenticate(String email, String password) throws Exception {
		Objects.requireNonNull(email);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials", e);
		}
	}

	public JwtResponse getUserWithJwtToken(String userName, String token) {
		Optional<User> control = findByUserName(userName);
		if (control.isPresent()) {
			User user = control.get();

			return new JwtResponse(token, user);
		}
		return null;
	}

}
