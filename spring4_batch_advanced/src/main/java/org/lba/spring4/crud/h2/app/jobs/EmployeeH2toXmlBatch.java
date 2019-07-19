package org.lba.spring4.crud.h2.app.jobs;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeH2toXmlBatch {

	static final Logger logger = Logger.getLogger(EmployeeH2toXmlBatch.class);

	static Job jobObj;
    static JobLauncher jobLauncherObj;
    static ApplicationContext contextObj;
    
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/h2-config/batch/jobs/spring-beans-db2xml.xml");
		/*1. Configure job*/
        jobObj = (Job) context.getBean("H2DBtoXmlFileJob");
        jobLauncherObj = (JobLauncher) context.getBean("jobLauncher");  
        /*2. Execute job*/
        try {
            JobExecution execution = jobLauncherObj.run(jobObj, new JobParameters());
            logger.debug("Exit Status : " + execution.getStatus());
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }
        
        logger.debug("Done");
		context.close();
	}
	
}
