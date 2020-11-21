package org.lba.spring4.db.model.relationship.manytomany.bidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_M2M_BIDIRECTIONAL")
public class AddressM2MBidirectional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDR_ID")
	private long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ZIP")
	private String zip;

	/**
	 To define a many-to-many bidirectional association, the @ManyToMany annotation must be used in the target and source entities. 
	 One entity must be defined as the owner and the other must use the mappedBy attribute to define its mapping.
	 */
	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "addresses")
	private List<EmployeeM2MBidirectional> employees = new ArrayList<>();

	public AddressM2MBidirectional() { }

	public AddressM2MBidirectional(String city, String state, String country, String zip) {
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public List<EmployeeM2MBidirectional> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeM2MBidirectional> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "AddressM2MBidirectional [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zip=" + zip + "]";
	}
	
	


}
