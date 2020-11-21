package org.lba.spring4.db.model.relationship.manytomany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_M2M_UNIDIRECTIONAL")
public class EmployeeM2MUnidirectional {

	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "EMP_ID")
	   private long id;

	   @Column(name = "NAME", nullable = false, unique = true)
	   private String name;

	   @Column(name = "DESIGNATION")
	   private String designation;

	   @Column(name = "SALARY")
	   private double salary;

	   /**
	    In many-to-many association, source entity has a field that stores collection of target entities. 
	    
	    The @ManyToMany JPA annotation is used to link the source entity with the target entity.

		A many-to-many association always uses an intermediate join table to store the association that joins two entities. 
		The join table is defined using the @JoinTable JPA annotation.

		The many-to-many association can be either unidirectional or bidirectional.

 		In unidirectional association, only source entity has a relationship field that refers to the target entities.
 	 	We can navigate this type of association from one side.

		In bidirectional association, each entity (i.e. source and target) has a relationship field that refers to each other. 
		We can navigate this type of association from both sides.
		
		The @JoinTable annotation is used to create the EMPLOYEE_ADDRESS join table. 
		This table defines an EMP_ID foreign key to the source entity’s table primary key and 
		an ADDR_ID foreign key to the target entity’s table primary key.
		
		So no explicit mapping are defined in other class: AddressM2MUnidirectional
	    */
	   @ManyToMany(cascade = CascadeType.ALL)
	   @JoinTable(name = "EMPLOYEE_ADDRESS_UNIDIRECTIONAL", 
	         joinColumns = { @JoinColumn(name = "EMP_ID") }, 
	         inverseJoinColumns = { @JoinColumn(name = "ADDR_ID") })
	   private List<AddressM2MUnidirectional> addresses = new ArrayList<>();

	   public EmployeeM2MUnidirectional() { }
	   
	   public EmployeeM2MUnidirectional(String name, String designation, double salary) {
	      this.name = name;
	      this.designation = designation;
	      this.salary = salary;
	   }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<AddressM2MUnidirectional> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressM2MUnidirectional> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "EmployeeM2MUnidirectional [id=" + id + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	   
	   
	   
}
