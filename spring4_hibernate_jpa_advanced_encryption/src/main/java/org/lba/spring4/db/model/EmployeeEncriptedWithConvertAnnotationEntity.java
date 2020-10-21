package org.lba.spring4.db.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_ENCRYPTED_TRANSFORMER")
public class EmployeeEncriptedWithConvertAnnotationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	
	@Convert(converter = MyHibernateAESEncryptionAttributeConverter.class)
	private String email;

	public EmployeeEncriptedWithConvertAnnotationEntity() {
		super();
	}

	public EmployeeEncriptedWithConvertAnnotationEntity( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public EmployeeEncriptedWithConvertAnnotationEntity(Long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	
	public EmployeeEncriptedWithConvertAnnotationEntity(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
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
		return "EmployeeEntityColumnTransformer [id=" + id + ", name=" + name + ", surname=" + surname + ", email="
				+ email + "]";
	}

	

}