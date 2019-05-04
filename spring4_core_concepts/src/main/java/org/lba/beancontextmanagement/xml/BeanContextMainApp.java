package org.lba.beancontextmanagement.xml;

import org.lba.beancontextmanagement.xml.prototype.MessagePrototypeBean;
import org.lba.beancontextmanagement.xml.singleton.MessageSingletonBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanContextMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-bean-instantiation.xml");
		ctx.refresh();
		
		System.out.println("** Singleton **");
		MessageSingletonBean messageSingletonBean1 = ctx.getBean("messageSingletonBean", MessageSingletonBean.class);
		 
        // Setting the object properties.
		messageSingletonBean1.setId(1001);
		messageSingletonBean1.setMessage("Hello world!");
 
        System.out.println(messageSingletonBean1.toString());
 
        // Retrieve it again.
        MessageSingletonBean messageSingletonBean2 = ctx.getBean("messageSingletonBean", MessageSingletonBean.class);
        System.out.println(messageSingletonBean2.toString());
		
		System.out.println("** Prototype **");
		MessagePrototypeBean messagePrototypeBean1 = (MessagePrototypeBean) ctx.getBean("messagePrototypeBean");
		
		messagePrototypeBean1.setId(1001);
		messagePrototypeBean1.setMessage("Hello world!");
 
        System.out.println(messagePrototypeBean1.toString());
        
        // Retrieve it again.
        MessagePrototypeBean messagePrototypeBean2 = ctx.getBean("messagePrototypeBean", MessagePrototypeBean.class);
        System.out.println(messagePrototypeBean2.toString());
        
	}
}
