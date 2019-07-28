package org.lba.spring4.crud.integration.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.spring4.model.EmployeeModel;
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
		employeeService.sayHello();
		logger.debug("** TEST testSpringContextLoading() - START **");
	}
	
	@Test 
	public void saveEmployee() {
		logger.debug("** TEST saveEmployee - START **");
		EmployeeModel model = getTestEmployeeModel();
		/**/
		EmployeeModel savedEmployee = employeeService.saveModelObject(model);
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
	
	@Test 
	public void readEmployees() {
		
		logger.debug("** TEST readEmployees - START **");
		
		List<EmployeeModel> listEmployee = employeeService.getAllEmployee();
		logger.debug("Employees size: " + listEmployee.size());
		assertNotNull(listEmployee);
		
		logger.debug("** TEST readEmployees -   END **");
	}
	
	private EmployeeModel getTestEmployeeModel() {
		EmployeeModel employeeModel = new EmployeeModel();
		/**/
		employeeModel.setId(1);
		employeeModel.setName("aNameEmployee");
		employeeModel.setSurname("aSurnameEmployee");
		employeeModel.setBornDate(new Date());
		/**/
		return employeeModel;
	}
}
