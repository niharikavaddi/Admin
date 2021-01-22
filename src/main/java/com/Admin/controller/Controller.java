package com.Admin.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Admin.exception.NoContentException;
import com.Admin.model.Admin;
import com.Admin.model.Donor;
import com.Admin.service.Service;
import lombok.extern.slf4j.Slf4j;
import com.Admin.model.Requestor;

@RestController
@Slf4j
public class Controller {

	@Autowired
	Service service;

	@GetMapping(value = "/getadmins")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		log.info("Fetching all the admins");
		return new ResponseEntity<List<Admin>>(service.getAllAdmins(), HttpStatus.OK);
	}

	@GetMapping(value = "/getadminbyid/{id}")
	public ResponseEntity<Admin> getRequestorById(@PathVariable("id") int id) throws NoContentException {
		try {
			log.info("Fetching admins by id");
			return new ResponseEntity<Admin>(service.getAdminById(id), HttpStatus.OK);
		} catch (NoContentException ex) {
			throw new NoContentException("Data not found");
		}
	}

	@PostMapping(value = "/createadmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) throws SQLIntegrityConstraintViolationException {
		try {
			log.info("Admin added to db: " + admin.getName());
			return new ResponseEntity<Admin>(service.createAdmin(admin), HttpStatus.CREATED);
		} catch (SQLIntegrityConstraintViolationException ex) {
			throw new SQLIntegrityConstraintViolationException();
		}
	}

	@PutMapping(value = "/updateadmin/{id}")
	public ResponseEntity<Admin> updateRequestor(int id, @RequestBody Admin admin) {
		log.info("Updated admin info");
		return new ResponseEntity<Admin>(service.updateAdmin(id, admin), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteadmin/{id}")
	public boolean deleteRequestor(@PathVariable("id") int id) {
		log.warn("ADMIN DELETED");
		return service.deleteAdmin(id);
	}

	@GetMapping(value = "/approverequestor/{id}")
	public ResponseEntity<Requestor> approveRequestor(@PathVariable("id") int id) {
		log.info("Approved admin");
		return new ResponseEntity<Requestor>(service.approveRequestor(id), HttpStatus.OK);

	}

	@GetMapping(value = "/approvedonor/{id}")
	public ResponseEntity<Donor> approveDonor(@PathVariable("id") int id) {
		log.info("Approved donor");
		return new ResponseEntity<Donor>(service.approveDonor(id), HttpStatus.OK);
	}

	@PostMapping(value = "/authenticateadmin")
	public ResponseEntity<Admin> authenticateAdmin(@RequestBody Admin admin) throws NoSuchElementException {
		log.debug("Authenticating admin");
		return new ResponseEntity<Admin>(service.authenticateAdmin(admin), HttpStatus.OK);
	}
}