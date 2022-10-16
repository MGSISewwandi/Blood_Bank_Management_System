package com.project.bdms.Donateevent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.project.bdms.coordinator.Coordinator;

@Entity
public class Donateevent {

	



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String date;
	private String location;

	
	/* @Column(name="lecturer_fullname")
	@NotEmpty(message = "Enter your name")
		private String name;
	

	
	@Column(name="lecturer_address")
	@NotEmpty(message = "Enter your address")
	private String address;
	

	@Column(name="lecturer_dob")
	@NotEmpty(message = "Enter your dob")
	private String dob;
	
	*/
	
	@OneToOne
	@JoinColumn(name="coordinator_id")
	private Coordinator coordinator;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Coordinator getCoordinator() {
		return coordinator;
	}



	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	



	public Donateevent() {
		
	}

	

}
