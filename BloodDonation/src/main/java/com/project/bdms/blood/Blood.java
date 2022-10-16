package com.project.bdms.blood;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.project.bdms.Donor.Donor;
import com.project.bdms.Requesthospital.Requesthospital;


@Entity
public class Blood {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="blood_bloodgroup")
	private String bloodgroup;
	
	
	
	@OneToMany
	@JoinColumn(name="blood_id")
	private List<Donor> donor =new ArrayList<>();

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="blood_requesthospital",
				joinColumns = {@JoinColumn(name = "blood_id")},
				inverseJoinColumns = {@JoinColumn (name="requesthospital_id")})
	private Set<Requesthospital> requestHospital = new HashSet<>();


	
	public Set<Requesthospital> getRequestHospital() {
		return requestHospital;
	}



	public void setRequestHospital(Set<Requesthospital> requestHospital) {
		this.requestHospital = requestHospital;
	}



	public Blood() {
		
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



	



	
	
	



	public List<Donor> getDonor() {
		return donor;
	}



	public void setDonor(List<Donor> donor) {
		this.donor = donor;
	}



	@Override
	public String toString() {
		return  bloodgroup;
	}
	
	
}
