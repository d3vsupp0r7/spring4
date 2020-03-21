package org.lba.spring4.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeModel implements Serializable{

	private static final long serialVersionUID = -369768159886781215L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private Date bornDate;
	
	public EmployeeModel() {
		//Empty constructor
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", surname=" + surname + ", bornDate=" + bornDate + "]";
	}
	
}
