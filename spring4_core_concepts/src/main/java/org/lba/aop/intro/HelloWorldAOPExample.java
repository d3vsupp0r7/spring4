package org.lba.aop.intro;


import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {
	public static void main(String[] args) {
		/**/
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);
		/**/
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		//Invoking the target object without using AOP
		System.out.println("Invoking the target object without using AOP");
		target.writeMessage();
		/**/
		//Invoking the target object using AOP
		System.out.println("");
		System.out.println("Invoking the target object using AOP");
		proxy.writeMessage();
	}

}
