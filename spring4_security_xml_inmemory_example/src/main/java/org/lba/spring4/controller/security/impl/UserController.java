package org.lba.spring4.controller.security.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private  UserService service;
	
	@RequestMapping(value="/customLogin")
	public String customLoginPage(ModelMap model) {
		// http://localhost:8080/spring4_security_xml_inmemory_example/user/customLogin
		logger.debug("*** Called cutomLogin URL ***");
 		return "customLogin";
 	}
	
	@RequestMapping(value="/home")
	public String home(ModelMap model, Authentication authentication) {
		//http://localhost:8080/spring4_security_xml_inmemory_example/user/home 
		authentication.getPrincipal();
		model.addAttribute("user", service.getDataByUserName(authentication.getName()));
 		return "security/user-info";
 	}
	
	@RequestMapping(value="/error")
	public String error() {
 		return "security/access-denied";
 	}
} 
