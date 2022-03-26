package org.lba.spring4.batch.partitioner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.data.JobRecordDataTO;
import org.lba.spring4.batch.data.JobTableFilterTO;
import org.lba.spring4.batch.service.JobProcessorService;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

public class JobReader implements ItemReader<JobRecordDataTO>, ItemStream {

	static final  Logger LOGGER = Logger.getLogger(JobReader.class);
	
	/** The current index. */
	int currentIndex = 0;

	/** The Constant CURRENT_INDEX. */
	private static final String CURRENT_INDEX = "current.index";
	
	private List<JobRecordDataTO> recordsListFormDB;
	
	@Autowired
	private JobProcessorService jobService;
	
	/**/
	private String chunkPropertiesDbFilter;
	
	
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		LOGGER.debug("*** JobReader - open - START ***");
		/**/
		JobTableFilterTO readTableFilter = new JobTableFilterTO();
		/**/
		List<String> storeCodeLst = new ArrayList<>();
		storeCodeLst.add(chunkPropertiesDbFilter);
		readTableFilter.setDepartmentCodesList(storeCodeLst);
		/**/
		recordsListFormDB = jobService.readDbWithFilter(readTableFilter);
		/**/
		LOGGER.debug("*** JobReader - open -   END ***");
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		LOGGER.debug("*** JobReader - update - START ***");
		LOGGER.debug("\tJobReader - update - current index: " + currentIndex);
		executionContext.putLong(CURRENT_INDEX, currentIndex);
		LOGGER.debug("*** JobReader - update -   END ***");
		
	}

	@Override
	public void close() throws ItemStreamException {
		LOGGER.debug("*** JobReader - close - START ***");
		LOGGER.debug("\tJobReader close chuck for : " + chunkPropertiesDbFilter);
		LOGGER.debug("*** JobReader - close -   END ***");
		
	}

	@Override
	public JobRecordDataTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		LOGGER.debug("*** JobReader - read - START ***");
		LOGGER.debug("\tJobReader processing chuck of: " + chunkPropertiesDbFilter);
		if (recordsListFormDB != null && currentIndex < recordsListFormDB.size()) {
			int currentIndexToReturn = currentIndex;
			currentIndex++;
			return recordsListFormDB.get(currentIndexToReturn);
		}
		LOGGER.debug("\tJobReader END OF processing chuck for : " + chunkPropertiesDbFilter);
		LOGGER.debug("*** JobReader - read -   END ***");
		
		/*Return null on read method, to pass on processor*/
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getChunkPropertiesDbFilter() {
		return chunkPropertiesDbFilter;
	}

	public void setChunkPropertiesDbFilter(String chunkPropertiesDbFilter) {
		this.chunkPropertiesDbFilter = chunkPropertiesDbFilter;
	}

	/**
	 * 
	 * @return
	 */
	public List<JobRecordDataTO> getRecordsListFormDB() {
		return recordsListFormDB;
	}

	public void setRecordsListFormDB(List<JobRecordDataTO> recordsListFormDB) {
		this.recordsListFormDB = recordsListFormDB;
	}

}
