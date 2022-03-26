package org.lba.spring4.batch.partitioner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.service.JobProcessorService;
import org.springframework.beans.factory.annotation.Autowired;

public class PartitionerReaderImpl implements PartitionerReader{

	static final  Logger LOGGER = Logger.getLogger(PartitionerReaderImpl.class);

	//public static final Boolean IS_DEMO = true;
	public static final Boolean IS_DEMO = false;
	
	@Autowired
	private JobProcessorService jobService;
	
	@Override
	public List<String> getGroupedData() throws Exception {
	
		LOGGER.debug("* PartitionerReaderImpl - getGroupedData - START");
		List<String> listOfPartition = null;
		
		if(IS_DEMO) {
			LOGGER.debug("* PartitionerReaderImpl - DEMO");
			listOfPartition = getDemoData();
		}else {
			LOGGER.debug("* PartitionerReaderImpl - H2 DB");
			listOfPartition = jobService.getGroupedData();
		}
		LOGGER.debug("* PartitionerReaderImpl - getGroupedData -   END");
		return listOfPartition;
	}
	
	/*************************/
	private List<String> getDemoData(){
		List<String> demoData = new ArrayList<>();
		/**/
		demoData.add("001");
		demoData.add("002");
		demoData.add("003");
		demoData.add("004");
		/**/
		return demoData;
	}
}
