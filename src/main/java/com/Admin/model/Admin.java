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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_ID")
	private int id;

	@Column(name = "userName", length = 20, unique = true)
	private String userName;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "ADMIN_NAME", length = 20)
	private String name;

	@Column(name = "ADMIN_AGE")
	private int age;

	@Column(name = "ADMIN_LOCATION", length = 10)
	private String location;

	@Column(name = "BLOODBANK_NAME", length = 10)
	private String bloodBankName;

}
