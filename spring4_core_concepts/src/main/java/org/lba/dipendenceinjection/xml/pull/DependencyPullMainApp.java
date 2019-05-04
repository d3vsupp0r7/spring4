package org.lba.dipendenceinjection.xml.pull;

import org.lba.spring4.message.render.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyPullMainApp {

	public static void main(String[] args) {
		ApplicationContext springXmlFileContext = new ClassPathXmlApplicationContext
				("META-INF/spring/app-context.xml");
		MessageRenderer mr = springXmlFileContext.getBean("renderer", MessageRenderer.class);
		mr.render();
		//
		((ConfigurableApplicationContext)springXmlFileContext ).close();
	}
}
