package org.lba.spring4.springintegration.message;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class EmployeePayload implements Serializable{

	@Override
	public String toString() {
		return "EmployeePayload [name=" + name + ", surname=" + surname + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4855883788169075108L;
	
	private String name;
	private String surname;
	
	public EmployeePayload() {
		// Implement if necessary
	}
	
	/**
	 * 
	 * @param name
	 * @param surname
	 */
	public EmployeePayload(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
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

	
}
