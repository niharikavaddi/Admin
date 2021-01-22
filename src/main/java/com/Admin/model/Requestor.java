package com.Admin.model;

import java.sql.Date;
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
@Table(name = "requestor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requestor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int requestorId;

	@Column(name = "patientName", length = 20)
	private String patientName;

	@Column(name = "bloodGroup", length = 5)
	private String bloodGroup;

	@Column(name = "city", length = 20)
	private String city;

	@Column(name = "doctorName", length = 20)
	private String doctorName;

	@Column(name = "hospitalName", length = 20)
	private String hospitalName;

	@Column(name = "hospitalAddress", length = 20)
	private String hospitalAddress;

	@Column(name = "date")
	private Date date;

	@Column(name = "contactNumber")
	private long contactNumber;

	@Column(name = "contactName", length = 20)
	private String contactName;

	@Column(name = "email", length = 20)
	private String email;

	@Column(name = "message", length = 20)
	private String message;

	@Column(name = "approvalStatus", length = 10)
	private String approvalStatus;

	@Column(name = "userName", length = 20, unique = true)
	private String userName;

	@Column(name = "password", length = 20)
	private String password;

}
