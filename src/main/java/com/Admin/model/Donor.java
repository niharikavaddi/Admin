package com.Admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Patient_id;

	@Column(name = "Donor_Name")
	private String donorName;

	@Column(name = "userName", length = 20, unique = true)
	private String userName;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "BloodGroup")
	private String bloodGroup;

	@Column(name = "City")
	private String city;

	@Column(name = "Time")
	private String time;

	@Column(name = "Blood_Glucose_Level")
	private String bloodGlucoseLevel;

	@Column(name = "Donor_Status")
	private String approveDonor;
}