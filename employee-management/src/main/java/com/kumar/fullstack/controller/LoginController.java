package com.kumar.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.fullstack.model.User;
import com.kumar.fullstack.service.LoginService;

@CrossOrigin(origins= {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/user")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	@GetMapping("/login/{emailId}")
	public ResponseEntity<User>login(@PathVariable String emailId,@RequestParam String password){
		
		return ResponseEntity.ok(loginService.login(emailId,password));
	}
	
	@PostMapping("/create")
	public ResponseEntity<User>createUser(@RequestBody User user){
		return ResponseEntity.ok(loginService.createUser(user));
	}

}
