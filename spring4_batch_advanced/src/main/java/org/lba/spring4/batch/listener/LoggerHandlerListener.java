package org.lba.spring4.batch.listener;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;

public class LoggerHandlerListener {

	static final Logger LOGGER = Logger.getLogger(LoggerHandlerListener.class);
	
	@BeforeJob
	public void beforeJob(JobExecution jobExecution) {
		LOGGER.debug("JOB ABOUT TO BEGIN");
	}
	
	@AfterJob
	public void afterJob(JobExecution jobExecution) {
		LOGGER.debug("JOB COMPLETED with status: " + jobExecution.getStatus());
	}

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		LOGGER.debug("BeforeStep:" + stepExecution.getStepName() + " Start:" + stepExecution.getStartTime());
	}

	@AfterStep
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.debug("AfterStep:" + stepExecution.getStepName() + " Stop:" + new Date());
		return stepExecution.getExitStatus();
	}
}
