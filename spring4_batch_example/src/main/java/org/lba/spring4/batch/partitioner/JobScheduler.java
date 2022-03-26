package org.lba.spring4.batch.partitioner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

public class JobScheduler {

	static final  Logger LOGGER = Logger.getLogger(JobScheduler.class);
	
	/** The job launcher. */
	@Autowired
	@Qualifier("jobNameToRunLauncher")
	private JobLauncher jobLauncher;

	/** The job process expired prescription. */
	@Autowired
	private Job jobNameToRun;
	
	/*Schedule every 20 min: 
	 * 0 0/20 * * * ? => At second :00, every 20 minutes starting at minute :00, of every hour
	 * @Scheduled(cron = "${jobNameToRun.expression:0 0/20 * * * ?}")
	 */
	//Schedeule : 0 * * * * ? => At second :00 of every minute
	@Scheduled(cron = "${jobNameToRun.expression:0 * * * * ?}")
	public void runJob() throws Exception {
		
		LOGGER.debug("*** JobScheduler - runJob - START ***");
				
		Map<String, JobParameter> jobParams = new HashMap<>();

		String uniqueID = UUID.randomUUID().toString();
		// initialize new variable
		jobParams.put("UUID", new JobParameter(uniqueID));

		// initialize new variable
		JobParameters jp = new JobParameters(jobParams);

		try {

			jobLauncher.run(jobNameToRun, jp);
			
		} catch (Exception e) {
			LOGGER.error("Run jobNameToRun Failed", e);
		}

		LOGGER.info("Started job jobNameToRun");
		LOGGER.debug("*** JobScheduler - runJob -   END ***");
	}
}
