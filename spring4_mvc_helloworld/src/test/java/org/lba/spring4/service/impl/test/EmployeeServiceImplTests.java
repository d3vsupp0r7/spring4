package org.lba.spring4.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.spring4.db.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring-test-database-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTests {
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void whenListAllEmployees_returnThreeElements() {

		List<Employee> listAllEmployee = employeeService.listAllEmployees();
		assertNotNull(listAllEmployee);
		assertEquals(3, listAllEmployee.size());
	}
	
	@Test
	public void whenGetEmployeeById_returnFoundEmployee() {

		Employee employee = employeeService.findById(1L);
		assertNotNull(employee);
		assertEquals("ASampleName001", employee.getName());
	}
	
}
