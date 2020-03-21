package org.lba.spring4.crud.integration.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.spring4.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath:/springTestContext/crud/spring-test-context-crud_with_initial_load.xml"})
public class H2DatabaseCrudOperationTests {

	final static Logger logger = Logger.getLogger(H2DatabaseCrudOperationTests.class);

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testSpringContextLoading() {
		logger.debug("** TEST testSpringContextLoading() - START **");
		logger.debug("A sample test for checking the spring test context bean build correctly");
	//	employeeService.sayHello();
		logger.debug("** TEST testSpringContextLoading() - START **");
	}

	/* CREATE */
	@Test 
	public void saveEmployee() {
		logger.debug("** TEST saveEmployee - START **");
		Employee model = getTestEmployeeModel();
		/**/
		Employee savedEmployee = employeeService.saveEmployee(model);
		/**/
		logger.debug("Saved Employee ID: " + savedEmployee.getId());
		logger.debug("Saved Employee NAME: " + savedEmployee.getName());
		logger.debug("Saved Employee SURNAME: " + savedEmployee.getSurname());
		/**/
		assertNotNull(savedEmployee);
		assertEquals(model.getId(), savedEmployee.getId());
		assertEquals(model.getSurname(), savedEmployee.getSurname());
		assertEquals(model.getName(), savedEmployee.getName());
		/**/
		logger.debug("** TEST saveEmployee -   END **");
	}

	/* READ */
	@Test 
	public void readEmployees() {

		logger.debug("** TEST readEmployees - START **");

		List<Employee> listEmployee = employeeService.listAllEmployees();
		logger.debug("Employees size: " + listEmployee.size());
		assertNotNull(listEmployee);

		logger.debug("** TEST readEmployees -   END **");
	}

	@Test 
	public void readEmployeeById() {

		logger.debug("** TEST readEmployees - START **");

		Employee employee = employeeService.findById(1l);
		logger.debug("Employees size: " + employee.toString());
		assertNotNull(employee);

		logger.debug("** TEST readEmployees -   END **");
	}

	private Employee getTestEmployeeModel() {
		Employee employeeModel = new Employee();
		/**/
		employeeModel.setId(1l);
		employeeModel.setName("aNameEmployee");
		employeeModel.setSurname("aSurnameEmployee");
		employeeModel.setBornDate(new Date());
		/**/
		return employeeModel;
	}
}
