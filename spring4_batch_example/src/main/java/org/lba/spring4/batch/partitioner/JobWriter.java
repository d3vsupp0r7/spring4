package org.lba.spring4.batch.partitioner;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.data.JobRecordDataTO;
import org.lba.spring4.db.model.ProcessedEmployeeModel;
import org.lba.spring4.service.ProcessedEmployeeService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class JobWriter implements ItemWriter<JobRecordDataTO>{

	static final  Logger LOGGER = Logger.getLogger(JobWriter.class);
	
	@Autowired
	private ProcessedEmployeeService processedEmployeeService;
	
	@Override
	@Transactional
	public void write(List<? extends JobRecordDataTO> items) throws Exception {
		LOGGER.debug("*** JobWriter - write - START ***");
		LOGGER.debug("\tJobWriter - items size to write: " + items.size());
		
		List<ProcessedEmployeeModel> toSave = new ArrayList<ProcessedEmployeeModel>();
		toSave = convertItemsToSave(items);
		/**/
		processedEmployeeService.saveAll(toSave);
		/**/
		LOGGER.debug("*** JobWriter - write -   END ***");
		
	}

	private List<ProcessedEmployeeModel> convertItemsToSave(List<? extends JobRecordDataTO> items) {
		
		List<ProcessedEmployeeModel> toSave = new ArrayList<ProcessedEmployeeModel>();
		/**/
		for (JobRecordDataTO currentItem : items) {
			ProcessedEmployeeModel obj = new ProcessedEmployeeModel();
			/**/
			obj.setName(currentItem.getName());
			obj.setSurname(currentItem.getSurname());
			obj.setDepartmentcode(currentItem.getDepartmentcode());
			/**/
			toSave.add(obj);
		}
		/**/
		return toSave;
	}

}
