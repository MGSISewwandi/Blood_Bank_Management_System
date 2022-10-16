package com.project.bdms.Requesthospital;

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

import com.project.bdms.blood.Blood;
import com.project.bdms.bloodstock.Bloodstock;


@Entity
public class Requesthospital {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="hospital_date")

	private String date;
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name="hospital_name")

		private String hospitalname;
	

	

	
	

	@Column(name="hospital_city")
	
	private String city;
	
	@Column(name="hospital_contactno")

	private String contactno;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="blood_requesthospital",
				joinColumns = {@JoinColumn(name = "requesthospital_id")},
				inverseJoinColumns = {@JoinColumn (name="blood_id")})

	private Set<Blood> blood = new HashSet<>();
	
	
	/* @ManyToOne
	@JoinColumn(name = "donor_id")
	private Donor donor;
	*/

	public Requesthospital() {
		
	}
	
	public Requesthospital(String hospitalname) {
		super();
		this.hospitalname = hospitalname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	/* public Donor getDepartment() {
		return donor;
	}

	public void setDepartment(Donor donor) {
		this.donor = donor;
	}
 
 */
	
	
	
	

	public String getCity() {
		return city;
	}

	public Set<Blood> getBlood() {
		return blood;
	}

	public void setBlood(Set<Blood> blood) {
		this.blood = blood;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

}
