package org.lba.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class CustomFactoryBean implements FactoryBean<MyBean>, InitializingBean {

	private String defaultParam = "a";
	
	private MyBean myBean = null;
	
	@Override
	public MyBean getObject() throws Exception {
		return myBean;
	}

	@Override
	public Class<? extends MyBean> getObjectType() {
		return MyBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("Init phase of CustomFactoryBean");
		myBean = MyBean.getInstance(defaultParam);
	}

	public void setDefaultParam(String aParam) {
		this.defaultParam = aParam;
	}
}
