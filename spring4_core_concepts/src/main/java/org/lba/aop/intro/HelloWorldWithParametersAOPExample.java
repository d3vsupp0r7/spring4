package org.lba.aop.intro;


import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldWithParametersAOPExample {
	public static void main(String[] args) {
		System.out.println("** MessageWriterWithPrameters **");
		/**/
		MessageWriterWithPrameters target = new MessageWriterWithPrameters();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecoratorWithTargetParams());
		pf.setTarget(target);
		/**/
		MessageWriterWithPrameters proxy = (MessageWriterWithPrameters) pf.getProxy();
		//Invoking the target object without using AOP
		System.out.println("Invoking the target object without using AOP");
		target.writeMessageWithParameters("aParam1", 10);
		/**/
		//Invoking the target object using AOP
		System.out.println("");
		System.out.println("Invoking the target object using AOP");
		proxy.writeMessageWithParameters("aParam1", 10);
	}

}
