package org.lba.spring4.batch.multistep.writer;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.data.JobRecordDataTO;
import org.springframework.batch.item.ItemProcessor;

public class WriterStep1 implements ItemProcessor<List<JobRecordDataTO>, List<JobRecordDataTO>> {

	static final  Logger LOGGER = Logger.getLogger(WriterStep1.class);

	@Override
	public List<JobRecordDataTO> process(List<JobRecordDataTO> item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
