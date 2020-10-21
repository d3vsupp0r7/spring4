package org.lba.spring4.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name="EMPLOYEE_ENCRYPTED_TEST")
public class EmployeeWithColumnTransformerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	
	@ColumnTransformer(
	            read = "TRIM(CHAR(0) FROM UTF8TOSTRING(DECRYPT('AES', HASH('SHA256', STRINGTOUTF8('secret-key-12345'), 1), email)))",
	            write = "ENCRYPT('AES', HASH('SHA256', STRINGTOUTF8('secret-key-12345'), 1), STRINGTOUTF8(?))"
	    )
	private String email;
	
	public EmployeeWithColumnTransformerEntity() {
		super();
	}

	public EmployeeWithColumnTransformerEntity( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public EmployeeWithColumnTransformerEntity(Long id, String name, String surname) {
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

	@Override
	public String toString() {
		return "EmployeeEntityColumnTransformerTest [id=" + id + ", name=" + name + ", surname=" + surname + ", email="
				+ email + "]";
	}

	
		
}