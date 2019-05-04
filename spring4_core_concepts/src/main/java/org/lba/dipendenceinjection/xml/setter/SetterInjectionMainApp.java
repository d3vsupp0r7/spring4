package org.lba.dipendenceinjection.xml.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMainApp {

	public static void main(String[] args) {
		ApplicationContext springXmlFileContext = new ClassPathXmlApplicationContext
				("META-INF/spring/app-context.xml");
		System.out.println("** First test **");
		SetterInjectionWithPrimitive setterInjectionWithPrimitive = springXmlFileContext.getBean("setterInjectionWithPrimitive", SetterInjectionWithPrimitive.class);
		System.out.println(setterInjectionWithPrimitive.toString());
		System.out.println("** Second test **");
		SetterInjection setterInjection = springXmlFileContext.getBean("setterInjection", SetterInjection.class);
		System.out.println(setterInjection.toString());
		//
		((ConfigurableApplicationContext)springXmlFileContext ).close();
	}
}
