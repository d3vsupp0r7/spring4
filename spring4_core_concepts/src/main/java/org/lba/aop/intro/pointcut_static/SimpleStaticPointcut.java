package org.lba.aop.intro.pointcut_static;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * 
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
	
	@Override
	public boolean matches(Method method, Class<?> cls) {
		return ("foo".equals(method.getName()));
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			public boolean matches(Class<?> cls) {
				return (cls == BeanOne.class);
			}
		};
	}

}
