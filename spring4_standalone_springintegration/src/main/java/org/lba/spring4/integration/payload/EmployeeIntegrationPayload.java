package org.lba.spring4.integration.payload;

import java.io.Serializable;

public class EmployeeIntegrationPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3681468763182997099L;

	private Long id;
	private String name;
	private String surname;
	
	public EmployeeIntegrationPayload() {
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

	@Override
	public String toString() {
		return "EmployeeIntegrationPayload [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
	
}
