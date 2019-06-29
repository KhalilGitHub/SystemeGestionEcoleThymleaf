package com.objis.cam.sgethymleaf.controller;




import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import com.objis.cam.sgethymleaf.service.UserService;
import com.objis.cam.sgethymleaf.service.UserServiceImpl;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}
   
	
	
}