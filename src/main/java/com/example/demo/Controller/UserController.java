package com.example.demo.Controller;

import com.example.demo.Entity.User;

import com.example.demo.Service.UserService;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public List<User> listUsers() {

		return userService.findAll();
	}
	@GetMapping("/printTable")
	public void printTable() throws JRException, ParseException, FileNotFoundException {
		System.out.println("printTable");
		userService.printTable();
	}

}
