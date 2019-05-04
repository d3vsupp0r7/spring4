package org.lba.profile.xml;

import java.util.List;

import org.lba.profile.Employee;
import org.lba.profile.EmployeeService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileEmployeesXmlMainApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/*-config.xml");
		ctx.refresh();
		EmployeeService employeeProviderService =
				ctx.getBean("employeeService", EmployeeService.class);
		List<Employee> employeeList = employeeProviderService.provideEmployee();
		for (Employee employee: employeeList) {
			System.out.println("Employee: " + employee.toString());
		}
	}
}
