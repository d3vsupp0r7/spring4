package org.lba.environment;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ExternalPropertyLoaderPlaceholder {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-external-property-config.xml");
		ctx.refresh();
		ExternalPropertyBean appProperty = ctx.getBean("appProperty", ExternalPropertyBean.class);
		System.out.println("application.home: " + appProperty.getApplicationHome());
		System.out.println("user.home: " + appProperty.getUserHome());
		}
}
