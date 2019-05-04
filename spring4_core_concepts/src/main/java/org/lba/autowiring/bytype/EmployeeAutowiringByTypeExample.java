package org.lba.autowiring.bytype;

import java.io.Serializable;

public class EmployeeAutowiringByTypeExample implements Serializable{

	private static final long serialVersionUID = 2599576739287937851L;
	private String name;
	private String surname;
	private DepartmentAutowiringByTypeExample departmentAutowiringByType;
	
	public EmployeeAutowiringByTypeExample() {
		// Implement if necessary
	}
	
	public EmployeeAutowiringByTypeExample(String name, String surname,
			DepartmentAutowiringByTypeExample departmentAutowiringByType) {
		super();
		this.name = name;
		this.surname = surname;
		this.departmentAutowiringByType = departmentAutowiringByType;
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


	

	public DepartmentAutowiringByTypeExample getDepartmentAutowiringByType() {
		return departmentAutowiringByType;
	}

	public void setDepartmentAutowiringByType(DepartmentAutowiringByTypeExample departmentAutowiringByType) {
		this.departmentAutowiringByType = departmentAutowiringByType;
	}

	@Override
	public String toString() {
		return "EmployeeAutowiringByTypeExample [name=" + name + ", surname=" + surname
				+ ", departmentAutowiringByType=" + departmentAutowiringByType + "]";
	}
	
	
}
