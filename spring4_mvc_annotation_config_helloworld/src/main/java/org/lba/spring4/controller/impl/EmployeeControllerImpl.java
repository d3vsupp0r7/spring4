package org.lba.spring4.controller.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.controller.EmployeeController;
import org.lba.spring4.controller.data.EmployeeModel;
import org.lba.spring4.db.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee-web")
public class EmployeeControllerImpl implements EmployeeController{

	static final Logger logger = Logger.getLogger(EmployeeControllerImpl.class);

	@Autowired
	private EmployeeService employeeService;

	/* CREATE */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String setupForm(Model model)
	{
		EmployeeModel employeeVO = new EmployeeModel();
		model.addAttribute("employee", employeeVO);
		return "employees/form/addEmployee";
	}

	@Override
	@RequestMapping(value = "/submitAddEmployee", method = RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") EmployeeModel aEmployee, BindingResult result) {

		//Validation code start
		boolean error = false;
		//Verifying if information is same as input by user  
		logger.debug("Employee form data: " + aEmployee.toString()); 

		error = validateEmployeeForm(aEmployee, result);
		
		if(error) {
			return "employees/form/addEmployee";
		}
		
		Employee employee = new Employee(aEmployee.getName(), aEmployee.getSurname());
		employeeService.saveEmployee(employee);


		return "redirect:/employee-web/readEmployees";
	}

	private boolean validateEmployeeForm(EmployeeModel aEmployee,  BindingResult result) {

		boolean error = false;
		
		if(aEmployee.getName().isEmpty()){
			result.rejectValue("name", "error.name");
			error = true;
		}

		if(aEmployee.getSurname().isEmpty()){
			result.rejectValue("surname", "error.surname");
			error = true;
		}
		
		return error;
	}

	/* READ */
	
	@Override
	@GetMapping("/readEmployees")
	public String readAllEmployees(ModelMap model) {

		List<Employee> employeeFromDB = employeeService.listAllEmployees();
		model.addAttribute("employees",employeeFromDB);
		return "employees/allEmployees";
	}

	/* UPDATE */
	@Override
	public EmployeeModel updateEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	/* DELETE */
	
	@Override
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/delete-employee/{id}" }, method = RequestMethod.GET)
	public String deleteEmployeeById(@PathVariable String id) {
		 employeeService.deleteEmployeeById(Long.parseLong(id));
		 
		 return "redirect:/employee-web/readEmployees";
	}


}
