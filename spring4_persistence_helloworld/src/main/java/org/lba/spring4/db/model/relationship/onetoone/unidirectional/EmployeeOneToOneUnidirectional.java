package org.lba.spring4.db.model.relationship.onetoone.unidirectional;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_O2O_Unidirectional")
public class EmployeeOneToOneUnidirectional {

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
	 In one-to-one association, source entity has a field that references another target entity. 
	 The @OneToOne JPA annotation is used to map the source entity with the target entity.

	The one-to-one association can be either unidirectional or bidirectional.  

	In unidirectional association, source entity has a relationship field that refers to the target entity 
	and the source entity’s table contains the foreign key.

	In bidirectional association, each entity (i.e. source and target) has a relationship field that refers 
	to each other and the target entity’s table contains the foreign key. 
	
	The source entity must use the mappedBy attribute to define the bidirectional one-to-one mapping.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USR_DET_ID")
	private EmployeeDetailsOneToOneUnidirectional employeeDetail;

	public EmployeeOneToOneUnidirectional() {

	}

	public EmployeeOneToOneUnidirectional(String firstname, String lastname, String phone) {
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
	
	public EmployeeDetailsOneToOneUnidirectional getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetailsOneToOneUnidirectional employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	@Override
	public String toString() {
		return "EmployeeOneToOneUnidirectional [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", birthDate=" + birthDate + ", cellphone=" + cellphone + "]";
	}

}
