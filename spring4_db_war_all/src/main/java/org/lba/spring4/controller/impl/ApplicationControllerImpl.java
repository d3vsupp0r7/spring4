package org.lba.spring4.controller.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.controller.ApplicationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationControllerImpl implements ApplicationController {

	static final Logger logger = Logger.getLogger(ApplicationControllerImpl.class);

	@RequestMapping(value = "/",method=RequestMethod.GET)
	public ModelAndView helloWorld() {

		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/toSaveFile",method=RequestMethod.GET)
	public ModelAndView toSaveFile() {

		return new ModelAndView("submitSingleFile");
	}
}
