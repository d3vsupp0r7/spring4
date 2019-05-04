package org.lba.autowiring.byname;

import java.io.Serializable;

public class EmployeeAutowiringByNameExample implements Serializable{

	private static final long serialVersionUID = 2599576739287937851L;
	private String name;
	private String surname;
	private DepartmentAutowiringByNameExample departmentAutowiringByName;
	
	public EmployeeAutowiringByNameExample() {
		// Implement if necessary
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


	public DepartmentAutowiringByNameExample getDepartmentAutowiringByName() {
		return departmentAutowiringByName;
	}

	public void setDepartmentAutowiringByName(DepartmentAutowiringByNameExample departmentAutowiringByName) {
		this.departmentAutowiringByName = departmentAutowiringByName;
	}

	@Override
	public String toString() {
		return "EmployeeAutowiringByNameExample [name=" + name + ", surname=" + surname
				+ ", departmentAutowiringByName=" + departmentAutowiringByName + "]";
	}
	
	
}
