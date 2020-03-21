package org.lba.spring4.crud.h2.app.jobs;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeXmlToH2AdvancedBatch {

	static final Logger logger = Logger.getLogger(EmployeeXmlToH2AdvancedBatch.class);

	static Job jobObj;
    static JobLauncher jobLauncherObj;
    static ApplicationContext contextObj;
    
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/h2-config/batch/jobs/spring-beans-advanced_1.xml");
    	
		/*1. Configure job*/
        jobObj = (Job) context.getBean("advancedDefinition1Job");
        jobLauncherObj = (JobLauncher) context.getBean("jobLauncher");  
        /*2. Execute job*/
        try {
            JobExecution execution = jobLauncherObj.run(jobObj, new JobParameters());
            logger.debug("Exit Status : " + execution.getStatus());
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }
        
        logger.debug("Done");
        
        /*3. READ saved object to DB*/
		logger.debug("*** READ an object to H2 Database - START ***");
		EmployeeService launcher = context.getBean("employeeServiceImpl", EmployeeService.class);
		List<Employee> listEmployee = launcher.listAllEmployees();
		/*5. Iterate on saved object*/
		for (Employee employeeModel : listEmployee) {
			logger.debug("Employee: " + employeeModel.toString());
		}
		
		logger.debug("*** READ an object to H2 Database -   END ***");
		context.close();
	}
}
