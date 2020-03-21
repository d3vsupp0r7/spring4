package org.lba.spring4.business.example.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.business.example.IClassThree;

public class ConcreteClassThree implements IClassThree{

	static final Logger logger = Logger.getLogger(ConcreteClassThree.class);
	
	@Override
	public void cl3Method1() {
		logger.debug("ConcreteClassTwo - cl2Method1()");
		
	}

	@Override
	public void cl3Method2() {
		logger.debug("ConcreteClassTwo - cl2Method1()");
		
	}

}
