package com.tranning;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@Column(name="addid")
	public int Addid;
	@Column(name="city")
	public String city;
	@Column(name="houseno")
	public int housenumber;
	@OneToOne(targetEntity=Employee.class)
	public Employee eobj;
	public int getAddid() {
		return Addid;
	}
	public void setAddid(int addid) {
		Addid = addid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}
	public Employee getEobj() {
		return eobj;
	}
	public void setEobj(Employee eobj) {
		this.eobj = eobj;
	}
	
	
	
	
	

}
