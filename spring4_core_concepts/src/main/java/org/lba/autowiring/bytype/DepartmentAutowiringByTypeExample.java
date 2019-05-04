package org.lba.autowiring.bytype;

public class DepartmentAutowiringByTypeExample {

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
