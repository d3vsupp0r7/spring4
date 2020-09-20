package org.lba.spring4.db.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employeefull")
public class EmployeeFull {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	
	/*Numerics*/
	@Column(name="salary_double")
	private Double salaryDouble;
	
	@Column(name="salary_big_decimal")
	private BigDecimal salaryBigDecimal;

	
	/*Date Fields*/
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name="creation_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	/* Large Data*/
	@Column(name="useful_info")
    @Lob
    private Clob usefulInfo;
    
	@Column(name="document")
	@Lob
	private Blob document;

	public EmployeeFull() {
		super();
	}

	public EmployeeFull( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public EmployeeFull(Long id, String name, String surname) {
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
