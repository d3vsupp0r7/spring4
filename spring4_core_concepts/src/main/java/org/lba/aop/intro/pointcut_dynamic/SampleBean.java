package org.lba.aop.intro.pointcut_dynamic;

public class SampleBean {

	public void foo(int x) {
		System.out.println("Invoked foo() with: " + x);
	}
	public void bar() {
		System.out.println("Invoked bar()");
	}
}
