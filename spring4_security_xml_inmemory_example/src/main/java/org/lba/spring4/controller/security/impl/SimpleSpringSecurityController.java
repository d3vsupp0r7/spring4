package org.lba.spring4.controller.security.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleSpringSecurityController {

	static final Logger logger = Logger.getLogger(SimpleSpringSecurityController.class);
	
	@RequestMapping(value = { "/appLogin"})
	public String homePage(ModelMap model) {
		logger.debug("*** Called /appLogin URL ***");
		return "welcome";
	}
}
