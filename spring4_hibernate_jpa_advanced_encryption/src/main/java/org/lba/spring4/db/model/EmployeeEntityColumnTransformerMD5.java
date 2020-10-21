package org.lba.spring4.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name="EMPLOYEE_ENCRYPTED_MD5")
public class EmployeeEntityColumnTransformerMD5 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;

	/*TODO: MD5*/
	private String email;
	
	public EmployeeEntityColumnTransformerMD5() {
		super();
	}

	public EmployeeEntityColumnTransformerMD5( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public EmployeeEntityColumnTransformerMD5(Long id, String name, String surname) {
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		
}