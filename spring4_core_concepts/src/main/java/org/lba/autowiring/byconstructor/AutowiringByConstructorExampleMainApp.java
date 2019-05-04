package org.lba.autowiring.byconstructor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowiringByConstructorExampleMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-autowiring.xml");
		ctx.refresh();
		System.out.println("Using byConstructor:\n");
		
		EmployeeAutowiringByConstructorExample employee = (EmployeeAutowiringByConstructorExample) ctx.getBean ("employeeAutowiringByConstructor");
		 
        System.out.println(employee.getName());
 
        System.out.println(employee.getDepartmentAutowiringByConstructor().getDepartmentName());
        //
		((ConfigurableApplicationContext)ctx ).close();

	}
}
