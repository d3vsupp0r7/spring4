package org.lba.autowiring.bytype;

import org.lba.autowiring.Target;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowiringByTypeExampleMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-for-autowiring.xml");
		ctx.refresh();
		System.out.println("Using byType:\n");
		
		EmployeeAutowiringByTypeExample employee = (EmployeeAutowiringByTypeExample) ctx.getBean ("employeeAutowiringByType");
		 
        System.out.println(employee.getName());
 
        System.out.println(employee.getDepartmentAutowiringByType().getDepartmentName());
        //
		((ConfigurableApplicationContext)ctx ).close();

	}
}
