package org.lba.spring4.batch.tasklet;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PrintTasklet implements Tasklet{

	static final Logger logger = Logger.getLogger(PrintTasklet.class);
	
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		logger.debug(message);
		return RepeatStatus.FINISHED;
	}

}
