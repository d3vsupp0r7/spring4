package org.lba.spring4.controller.impl;

import org.lba.spring4.controller.ApplicationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationControllerImpl implements ApplicationController {

	@RequestMapping("/")
	public ModelAndView helloWorld() {

		return new ModelAndView("index");
	}
}
