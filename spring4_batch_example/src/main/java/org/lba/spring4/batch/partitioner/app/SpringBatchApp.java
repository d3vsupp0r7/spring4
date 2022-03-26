package org.lba.spring4.batch.partitioner.app;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchApp {

	static final  Logger LOGGER = Logger.getLogger(SpringBatchApp.class);
	
	public static void main(String[] args) {
		
		//1. Read Spring Context 
		ApplicationContext context = new ClassPathXmlApplicationContext(
						"springBatchJobPartitioner_example.xml");
		
		
		//2.
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("jobNameToRun");

		/*************************/
		LOGGER.debug("*** SpringBatchApp - printContextBean - START ***");
		String[] beans = context.getBeanDefinitionNames();
		LOGGER.debug("*** SpringBatchApp - printContextBean - number of beans: " + beans.length);
		Arrays.sort(beans);
		int id = 1;
		for (String bean : beans) 
		{
			//LOGGER.debug(id +") " + bean + " of Type :: " + context.getBean(bean).getClass());
			LOGGER.debug(id +") " + bean );
			id++;
		}
		LOGGER.debug("*** SpringBatchApp - printContextBean -   END ***");
		/*************************/
		
		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		/*Close Spring context*/
		((ConfigurableApplicationContext)context).close();
	}

}
