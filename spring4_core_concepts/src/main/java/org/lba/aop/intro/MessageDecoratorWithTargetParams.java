package org.lba.aop.intro;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *  This is the advice.
 *  MethodInterceptor: Execution before and after a target methd invocation.
 */
public class MessageDecoratorWithTargetParams implements MethodInterceptor {
		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Hello [from advice concrete class: Before] ");
		/*Print argument passed to target method inside the advice*/
		System.out.println("Print argument passed to target method inside the advice");
		System.out.println(Arrays.toString(invocation.getArguments()));
		/**/
		Object retVal = invocation.proceed();
		System.out.println("! [from advice concrete class: After]");
		return retVal;
		}
}
