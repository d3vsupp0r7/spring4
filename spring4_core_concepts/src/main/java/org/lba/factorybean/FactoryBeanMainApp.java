package org.lba.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FactoryBeanMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-factorybean.xml");
		ctx.refresh();
		Container container = (Container) ctx.getBean("container");
		container.sampleMethod("Hello World!");
		}
}
