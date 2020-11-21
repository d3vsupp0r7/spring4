package org.lba.spring4.db.model.relationship.onetomany.bidirectional;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT_O2M_Bidirectional")
public class DepartmentO2MBidirectional {

	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	/*
	 @OneToMany annotation defines a many-valued association with one-to-many multiplicity.
	If the collection is defined using generics to specify the element type, the associated target entity
 	type need not be specified; otherwise the target entity class must be specified.

	The association may be bidirectional. In a bidirectional relationship, one of the sides 
	(and only one) has to be the owner: the owner is responsible for the association column(s) update. 
	To declare a side as not responsible for the relationship, the attribute mappedBy is used. 
	mappedBy refers to the property name of the association on the owner side. 
	In our case, this is passport. 
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="department")
	private List<EmployeeOneToManyBidirectional> employees;
	
	public DepartmentO2MBidirectional() {
		//Implement if necessary
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<EmployeeOneToManyBidirectional> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeOneToManyBidirectional> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentO2MUnidirectional [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
}
