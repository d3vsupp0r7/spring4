package org.lba.spring4.db.model.relationship.onetomany.bidirectional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_O2M_Bidirectional")
public class EmployeeOneToManyBidirectional {

	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="cell_phone")
	private String cellphone;

	/**
	 To define a  one-to-many bidirectional association, the @ManyToOne annotation must be used in 
	 the target entity (i.e.  Employee entity) and the mappedBy attribute must be used
	 in the source entity (i.e.  Department entity).
	 
	 @ManyToOne annotation defines a single-valued association to another entity class that has 
	 many-to-one multiplicity. It is not normally necessary to specify the target entity explicitly 
	 since it can usually be inferred from the type of the object being referenced.

	@JoinColumn is used to specify a mapped column for joining an entity association.
	 */
	@ManyToOne
	@JoinColumn(name="department_id")
	private DepartmentO2MBidirectional department;

	public EmployeeOneToManyBidirectional() {

	}

	public EmployeeOneToManyBidirectional(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = new Date(System.currentTimeMillis());
		this.cellphone = phone;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public DepartmentO2MBidirectional getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentO2MBidirectional department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeOneToManyUnidirectional [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", birthDate=" + birthDate + ", cellphone=" + cellphone + "]";
	}
	
}
