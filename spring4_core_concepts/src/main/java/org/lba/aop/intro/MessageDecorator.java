package org.lba.aop.intro;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *  This is the advice.
 *  MethodInterceptor: Execution before and after a target methd invocation.
 */
public class MessageDecorator implements MethodInterceptor {
		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("Hello [from advice concrete class: Before] ");
		Object retVal = invocation.proceed();
		System.out.println("! [from advice concrete class: After]");
		return retVal;
		}
}
