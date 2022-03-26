package org.lba.spring4.batch.data;

import java.io.Serializable;

public class JobRecordDataTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4645413390901201390L;
	
	private Long id;
	private String name;
	private String surname;
	private String departmentcode;
	
	public JobRecordDataTO() {
		// Implement if necessary
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	
	

}
