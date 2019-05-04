package org.lba.autowiring.byname;

import org.lba.autowiring.Target;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowiringByNameExampleMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-autowiring.xml");
		ctx.refresh();
		System.out.println("Using byName:\n");
		
		EmployeeAutowiringByNameExample employee = (EmployeeAutowiringByNameExample) ctx.getBean ("employeeAutowiringByName");
		 
        System.out.println(employee.getName());
 
        System.out.println(employee.getDepartmentAutowiringByName().getDepartmentName());
        //
		((ConfigurableApplicationContext)ctx ).close();

	}
}
