package org.lba.autowiring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
	private MyBeanA foo;
	private MyBeanA foo2;
	private MyBeanB bar;
	public Target() {
	}
	public Target(MyBeanA foo) {
		System.out.println("Target(Foo) called");
	}
	public Target(MyBeanA foo, MyBeanB bar) {
		System.out.println("Target(Foo, Bar) called");
	}
	public void setFoo(MyBeanA foo) {
		this.foo = foo;
		System.out.println("Property foo set");
	}
	public void setFoo2(MyBeanA foo) {
		this.foo2 = foo;
		System.out.println("Property foo2 set");
	}
	public void setBar(MyBeanB bar) {
		this.bar = bar;
		System.out.println("Property bar set");
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-autowiring.xml");
		ctx.refresh();
		Target t = null;
		System.out.println("Using byName:\n");
		t = (Target) ctx.getBean("targetByName");
		System.out.println("\nUsing byType:\n");
		t = (Target) ctx.getBean("targetByType");
		System.out.println("\nUsing constructor:\n");
		t = (Target) ctx.getBean("targetConstructor");
	}
}
