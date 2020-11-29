package org.lba.spring4.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -951638027902813417L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "employeeSeq")
	@SequenceGenerator(name = "employeeSeq", sequenceName = "EMPLOYEE_SEQ", allocationSize=1)
	@Column(name = "ID")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	
	public Employee() {
	}

	public Employee( String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Employee(Long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
}
