package org.lba.spring4;

import org.apache.log4j.Logger;

public class HelloWorldSpringBean {
	
	static final Logger logger = Logger.getLogger(HelloWorldSpringBean.class);

	public void printHello() {
		logger.info("HelloWorldSpringBean: I Print Hello!!!");
		logger.debug("HelloWorldSpringBean: I Print Hello!!!");
	}
	
}
