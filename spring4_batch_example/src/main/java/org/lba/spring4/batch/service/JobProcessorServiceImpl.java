package org.lba.spring4.batch.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.data.JobRecordDataTO;
import org.lba.spring4.batch.data.JobTableFilterTO;
import org.lba.spring4.db.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class JobProcessorServiceImpl implements JobProcessorService {

	static final  Logger LOGGER = Logger.getLogger(JobProcessorService.class);
	
	public JobProcessorServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<String> getGroupedData() throws Exception {
		LOGGER.debug("* JobProcessorServiceImpl - getGroupedData - START");
		StringBuilder stringBuffer = new StringBuilder();
		/**/
		stringBuffer.append("SELECT e.departmentcode from " + EmployeeModel.class.getName() + " e ");
		stringBuffer.append(" group by  e.departmentcode");
		String result = stringBuffer.toString();
		LOGGER.debug("Query: " + result);
		/**/
		TypedQuery<String> query = entityManager.createQuery(result, String.class);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JobRecordDataTO> readDbWithFilter(JobTableFilterTO readTableFilter) {
		/**/
		List<JobRecordDataTO> result = null;
		/**/
		Query query = entityManager.createQuery(buildQueryFilter(readTableFilter));
		query.setParameter("departmentcodelist", readTableFilter.getDepartmentCodesList());
		List<EmployeeModel> employeeList = query.getResultList();
		
		if(employeeList!=null) {
			result = convertQueryResult(employeeList);
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param employeeList
	 * @return
	 */
	private List<JobRecordDataTO> convertQueryResult(List<EmployeeModel> employeeList) {
		List<JobRecordDataTO> listToReturn = new ArrayList<JobRecordDataTO>();
		/**/
		for (EmployeeModel dbRecord : employeeList) {
			JobRecordDataTO currentRecordToCovert = new JobRecordDataTO();
			/**/
			currentRecordToCovert.setId(dbRecord.getId());
			currentRecordToCovert.setName(dbRecord.getName());
			currentRecordToCovert.setSurname(dbRecord.getSurname());
			currentRecordToCovert.setDepartmentcode(dbRecord.getDepartmentcode());
			/**/
			listToReturn.add(currentRecordToCovert);
		}
		/**/
		return listToReturn;
	}

	
	/**
	 * 
	 * @param readTableFilter
	 * @return
	 */
	private String buildQueryFilter(JobTableFilterTO readTableFilter) {
		
		StringBuilder stringBuffer = new StringBuilder();
		/**/
		stringBuffer.append("SELECT e from " + EmployeeModel.class.getName() + " e ");
		stringBuffer.append(" WHERE e.departmentcode in (:departmentcodelist) ");
		stringBuffer.append("order by e,id asc");
		String result = stringBuffer.toString();
		LOGGER.debug("Query: " + result);
		/**/
		return result;
	}

}
