package org.lba.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloWorldSpringBean {

	
	public static void main(String[] args) {
		//1. Read Spring Context 
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		//2. Instantiate Spring Bean
		HelloWorldSpringBean obj = (HelloWorldSpringBean) context.getBean("helloBean");
		obj.printHello();
		//3. Close Spring context
				((AbstractApplicationContext) context).close();
		
	}
}
