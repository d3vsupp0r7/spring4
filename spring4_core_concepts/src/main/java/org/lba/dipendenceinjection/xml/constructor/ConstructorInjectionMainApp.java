package org.lba.dipendenceinjection.xml.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMainApp {

	public static void main(String[] args) {
		ApplicationContext springXmlFileContext = new ClassPathXmlApplicationContext
				("META-INF/spring/app-context.xml");
		System.out.println("** First test **");
		ConstructorInjectionWithPrimitive constructorInjectionWithPrimitive = springXmlFileContext.getBean("constructorInjectionWithPrimitive", ConstructorInjectionWithPrimitive.class);
		System.out.println(constructorInjectionWithPrimitive.toString());
		System.out.println("** Second test **");
		ConstructorInjection constructorInjectionBean = springXmlFileContext.getBean("constructorInjectionBean", ConstructorInjection.class);
		System.out.println(constructorInjectionBean.toString());
		System.out.println("** Third test **");
		ConstructorInjection constructorInjectionBeanTwo = springXmlFileContext.getBean("constructorInjectionBeanTwo", ConstructorInjection.class);
		System.out.println(constructorInjectionBeanTwo.toString());
		//
		((ConfigurableApplicationContext)springXmlFileContext ).close();
	}
}
