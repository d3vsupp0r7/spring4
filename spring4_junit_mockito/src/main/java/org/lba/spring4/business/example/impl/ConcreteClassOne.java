package org.lba.spring4.business.example.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.business.example.IClassOne;

public class ConcreteClassOne implements IClassOne{

	static final Logger logger = Logger.getLogger(ConcreteClassOne.class);
	
	@Override
	public void cl1Method1() {
		logger.debug("ConcreteClassOne - cl1Method1()");
		
	}

	@Override
	public void cl1Method2() {
		logger.debug("ConcreteClassOne - cl1Method2()");
		
	}

}
