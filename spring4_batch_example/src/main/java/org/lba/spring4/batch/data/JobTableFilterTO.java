package org.lba.spring4.batch.data;

import java.io.Serializable;
import java.util.List;

public class JobTableFilterTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2255498748611259865L;
	
	private List<String> departmentCodesList;
	
	public JobTableFilterTO() {
		// Implement if necessary
	}

	public List<String> getDepartmentCodesList() {
		return departmentCodesList;
	}

	public void setDepartmentCodesList(List<String> departmentCodesList) {
		this.departmentCodesList = departmentCodesList;
	}

	@Override
	public String toString() {
		return "JobTableFilterTO [departmentCodesList=" + departmentCodesList + "]";
	}
	
}
