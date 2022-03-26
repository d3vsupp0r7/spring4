package org.lba.spring4.batch.service;

import java.util.List;

import org.lba.spring4.batch.data.JobRecordDataTO;
import org.lba.spring4.batch.data.JobTableFilterTO;

public interface JobProcessorService {

	public List<String> getGroupedData() throws Exception;

	public List<JobRecordDataTO> readDbWithFilter(JobTableFilterTO readTableFilter);
}
