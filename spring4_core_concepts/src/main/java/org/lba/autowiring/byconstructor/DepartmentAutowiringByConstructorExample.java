package org.lba.autowiring.byconstructor;

public class DepartmentAutowiringByConstructorExample {

	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentAutowiringByNameExample [departmentName=" + departmentName + "]";
	}
	
	
}
