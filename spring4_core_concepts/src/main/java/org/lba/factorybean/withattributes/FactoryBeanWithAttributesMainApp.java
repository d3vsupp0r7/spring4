package org.lba.factorybean.withattributes;

import org.lba.factorybean.Container;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FactoryBeanWithAttributesMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-factorybean-withattributes.xml");
		ctx.refresh();
		Container container = (Container) ctx.getBean("container");
		container.sampleMethod("Hello World!");
		}
}
