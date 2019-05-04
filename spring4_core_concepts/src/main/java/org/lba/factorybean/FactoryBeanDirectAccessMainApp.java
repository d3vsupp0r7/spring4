package org.lba.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FactoryBeanDirectAccessMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-factorybean.xml");
		ctx.refresh();
		
		/**/
		MyBean aBean = (MyBean)ctx.getBean("beanAFactory");
		System.out.println("aBean: " + aBean.getParam());
		/**/
		CustomFactoryBean customFactory = (CustomFactoryBean) ctx.getBean("&beanAFactory");
		/**/
		try {
			MyBean aBeanFromFactory = customFactory.getObject();
			System.out.println(aBeanFromFactory.getParam());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		}
}
