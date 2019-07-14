package org.lba.spring4.batch.processor;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.model.Report;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {
	
	static final Logger logger = Logger.getLogger(CustomItemProcessor.class);
	
    public Report process(Report itemObj) throws Exception {
    	logger.debug("Processing Item = " + itemObj);
        return itemObj;
    }
}
