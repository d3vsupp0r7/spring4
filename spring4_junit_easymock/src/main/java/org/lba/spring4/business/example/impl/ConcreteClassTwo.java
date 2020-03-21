package org.lba.spring4.business.example.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.business.example.IClassTwo;

public class ConcreteClassTwo implements IClassTwo{

	static final Logger logger = Logger.getLogger(ConcreteClassTwo.class);
	
	@Override
	public void cl2Method1() {
		logger.debug("ConcreteClassTwo - cl2Method1()");
		
	}

	@Override
	public void cl2Method2() {
		logger.debug("ConcreteClassTwo - cl2Method2()");
		
	}

}
