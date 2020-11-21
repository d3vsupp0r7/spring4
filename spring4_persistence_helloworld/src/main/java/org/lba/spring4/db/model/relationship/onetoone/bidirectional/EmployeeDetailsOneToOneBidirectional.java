package org.lba.spring4.db.model.relationship.onetoone.bidirectional;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_DETAILS_O2O_Unidirectional")
public class EmployeeDetailsOneToOneBidirectional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_DET_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DBO")
	private LocalDate dob;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USR_ID")
	private EmployeeOneToOneBidirectional employee;

	public EmployeeDetailsOneToOneBidirectional() {
		// Implement if necessary
	}

	public EmployeeDetailsOneToOneBidirectional(String firstName, String lastName, String email, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public EmployeeOneToOneBidirectional getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeOneToOneBidirectional employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsOneToOneUnidirectional [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", dob=" + dob + "]";
	}

}
