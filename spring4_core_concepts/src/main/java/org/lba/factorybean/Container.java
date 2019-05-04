package org.lba.factorybean;

public class Container {
	
	private MyBean beanA;
	private MyBean beanB;

	public void setBeanA(MyBean beanA) {
		this.beanA = beanA;
	}

	public void setBeanB(MyBean beanB) {
		this.beanB = beanB;
	}
	
	public void sampleMethod(String aMessage) {
		
		System.out.println("Use of beanA");
		businessMethod(aMessage, beanA);
		/**/
		System.out.println("Use of beanB");
		businessMethod(aMessage, beanB);
	}

	private void businessMethod(String aMessage, MyBean bean) {

		System.out.println("Bean info: " + bean.getParam());
		
	}
	

}
