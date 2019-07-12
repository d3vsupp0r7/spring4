package org.lba.spring4.batch.app;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	static Job jobObj;
    static JobLauncher jobLauncherObj;
    static ApplicationContext contextObj;
    private static String[] springConfig  = {"spring/batch/jobs/spring-beans.xml" };
 
    public static void main(String[] args) {        
        // Loading The Bean Definition From The Spring Configuration File
    	GenericXmlApplicationContext contextObj = new GenericXmlApplicationContext();
    	contextObj.load("classpath:spring/batch/jobs/spring-beans.xml");
    	contextObj.refresh();
    	
        jobObj = (Job) contextObj.getBean("helloWorldJob");
        jobLauncherObj = (JobLauncher) contextObj.getBean("jobLauncher");  
        
        try {
            JobExecution execution = jobLauncherObj.run(jobObj, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }
        
        System.out.println("Done");
    }
}
