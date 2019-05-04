package org.lba.autowiring.byconstructor;

import java.io.Serializable;

public class EmployeeAutowiringByConstructorExample implements Serializable{

	private static final long serialVersionUID = 2599576739287937851L;
	private String name;
	private String surname;
	private DepartmentAutowiringByConstructorExample departmentAutowiringByConstructor;
	
	public EmployeeAutowiringByConstructorExample() {
		// Implement if necessary
	}
	
	public EmployeeAutowiringByConstructorExample(DepartmentAutowiringByConstructorExample departmentBean)
    {
        this.departmentAutowiringByConstructor = departmentBean;
    }

	public EmployeeAutowiringByConstructorExample(String name, String surname,
			DepartmentAutowiringByConstructorExample departmentAutowiringByConstructor) {
		super();
		this.name = name;
		this.surname = surname;
		this.departmentAutowiringByConstructor = departmentAutowiringByConstructor;
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
	
	

	public DepartmentAutowiringByConstructorExample getDepartmentAutowiringByConstructor() {
		return departmentAutowiringByConstructor;
	}

	public void setDepartmentAutowiringByConstructor(
			DepartmentAutowiringByConstructorExample departmentAutowiringByConstructor) {
		this.departmentAutowiringByConstructor = departmentAutowiringByConstructor;
	}

	@Override
	public String toString() {
		return "EmployeeAutowiringByConstructorExample [name=" + name + ", surname=" + surname
				+ ", departmentAutowiringByConstructor=" + departmentAutowiringByConstructor + "]";
	}
	
	
}
