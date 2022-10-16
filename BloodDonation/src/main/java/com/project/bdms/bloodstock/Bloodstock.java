package com.project.bdms.bloodstock;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.project.bdms.Requesthospital.Requesthospital;

@Entity
public class Bloodstock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="bloodstock_bloodgroup")
	private String bloodgroup;
	
	@Column(name="bloodstock_date")
	private String date;

	@Column(name="bloodstock_units")
	private String units;
	
	
	
	

	public Bloodstock() {
		
	}
	
	public Bloodstock(String bloodgroup) {
		super();
		this.bloodgroup = bloodgroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}
	
	

	@Override
	public String toString() {
		return bloodgroup;
	}

	
	
	
	
}
