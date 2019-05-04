package org.lba.beanlifecycle.initphase.postconstruct;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithJSR250PostConstructAnnotation {

	private static final String DEFAULT_NAME = "Luke Skywalker";
	private String name;
	private int age = Integer.MIN_VALUE;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@PostConstruct
	public void init() throws Exception {
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set the age property of any beans of type " +
							SimpleBeanWithJSR250PostConstructAnnotation.class);
		}
	}
	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-bean-lifecycle-annotation.xml");
		ctx.refresh();
		SimpleBeanWithJSR250PostConstructAnnotation simpleBean1 = getBean("simpleBean1PostConstruct", ctx);
		SimpleBeanWithJSR250PostConstructAnnotation simpleBean2 = getBean("simpleBean2PostConstruct", ctx);
		SimpleBeanWithJSR250PostConstructAnnotation simpleBean3 = getBean("simpleBean3PostConstruct", ctx);
	}

	private static SimpleBeanWithJSR250PostConstructAnnotation getBean(String beanName, ApplicationContext ctx) {
		try {
			SimpleBeanWithJSR250PostConstructAnnotation bean = (SimpleBeanWithJSR250PostConstructAnnotation) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException ex) {
			System.out.println("An error occured in bean configuration: "
					+ ex.getMessage());
			return null;
		}
	}
}
