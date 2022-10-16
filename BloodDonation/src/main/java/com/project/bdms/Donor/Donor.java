package com.project.bdms.Donor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.project.bdms.blood.Blood;



@Entity
public class Donor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="donor_name", length=60, nullable=false, unique = true )
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "blood_id")
	private Blood blood;
	
	
 
 @Column(name="donor_dob")
	private String dob;

	@Column(name="donor_gender")
	private String gender;

	
	
	
	public Donor() {
	
	}
	
	public Donor(Integer id) {
		
		this.id = id;
		
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

	

	

	public Blood getBlood() {
		return blood;
	}

	public void setBlood(Blood blood) {
		this.blood = blood;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	@Override
	public String toString() {
		return  name;
	}
	 
	

}
