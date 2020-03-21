package org.lba.spring4.business.example.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.business.example.IBusiness;
import org.lba.spring4.business.example.IClassOne;
import org.lba.spring4.business.example.IClassThree;
import org.lba.spring4.business.example.IClassTwo;
import org.springframework.beans.factory.annotation.Autowired;

public class ConcreteBusiness implements IBusiness{
	
	static final Logger logger = Logger.getLogger(ConcreteBusiness.class);
	
	@Autowired
	private IClassOne clasOne;
	
	@Autowired
	private IClassTwo clasTwo;
	
	@Autowired
	private IClassThree clasThree;

	@Override
	public void businessMethod1() {
		logger.debug("ConcreteBusiness - businessMethod1");
		clasOne.cl1Method1();
	}

	@Override
	public void businessMethod1(IClassTwo param1) {
		logger.debug("ConcreteBusiness - businessMethod1(IClassTwo param1)");
	}

	@Override
	public void businessMethod2(IClassOne param1) {
		logger.debug("ConcreteBusiness - businessMethod2(IClassOne param1)");
		
	}

	@Override
	public void businessMethod2(IClassTwo param1, IClassThree param2) {
		logger.debug("ConcreteBusiness - businessMethod2(IClassOne param1)");
		
	}

	@Override
	public void businessMethod3(IClassThree param1) {
		logger.debug("ConcreteBusiness - businessMethod3(IClassThree param1)");
		
	}

}
