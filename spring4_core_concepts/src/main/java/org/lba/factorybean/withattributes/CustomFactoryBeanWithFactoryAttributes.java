package org.lba.factorybean.withattributes;

import org.lba.factorybean.MyBean;

public class CustomFactoryBeanWithFactoryAttributes {

	private String defaultParam = "a";
	
	public MyBean createInstance() throws Exception{
		return MyBean.getInstance(defaultParam);
	}

	public void setDefaultParam(String aParam) {
		this.defaultParam = aParam;
	}
}
