package org.lba.spring4.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.spring4.db.model.EmployeeDBModel;
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

		List<EmployeeDBModel> listAllEmployee = employeeService.listAllEmployees();
		assertNotNull(listAllEmployee);
		assertEquals(3, listAllEmployee.size());
	}
	
	@Test
	public void whenGetEmployeeById_returnFoundEmployee() {

		EmployeeDBModel employee = employeeService.findById(1L);
		assertNotNull(employee);
		assertEquals("ASampleName001", employee.getName());
	}
	
	@Test
	public void whenSaveNewEmployee_returnSavedEmployee() {

		EmployeeDBModel employee = new EmployeeDBModel("JUnitEmployeeName","JUnitEmployeeSurname");
		EmployeeDBModel savedEmployee = employeeService.saveEmployee(employee);
		assertNotNull(savedEmployee);
		assertEquals("JUnitEmployeeName", savedEmployee.getName());
	}
	
}
