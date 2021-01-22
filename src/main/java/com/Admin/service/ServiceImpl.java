package com.Admin.service;

import java.net.URI;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.Admin.exception.NoContentException;
import com.Admin.model.Admin;
import com.Admin.model.Donor;
import com.Admin.model.Requestor;
import com.Admin.repository.Repository;

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

	@Autowired
	Repository repository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Admin> getAllAdmins() {
		return repository.findAll();
	}

	@Override
	public Admin getAdminById(int id) throws NoContentException {
		Optional<Admin> admin = repository.findById(id);
		if (admin.isPresent()) {
			return admin.get();
		} else {
			throw new NoContentException("Data not found");
		}
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		Optional<Admin> updateAdmin = repository.findById(id);
		if (updateAdmin.isPresent()) {
			Admin newAdmin = updateAdmin.get();
			newAdmin = admin;
			return repository.save(newAdmin);
		} else {
			return repository.save(updateAdmin.get());
		}
	}

	@Override
	public boolean deleteAdmin(int id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public Requestor approveRequestor(int id) {
		URI uri = URI.create("http://localhost:9094/approverequestor" + id);
		return this.restTemplate.getForObject(uri, Requestor.class);

	}

	@Override
	public Donor approveDonor(int id) {
		URI uri = URI.create("http://localhost:9090/approvedonor" + id);
		return this.restTemplate.getForObject(uri, Donor.class);
	}

	@Override
	public Admin createAdmin(Admin admin) throws SQLIntegrityConstraintViolationException {
		return repository.save(admin);
	}

	@Override
	public Admin authenticateAdmin(Admin admin) throws NoSuchElementException {
		List<Admin> requestors = repository.findAll();
		System.out.println(admin.getUserName() + admin.getPassword());
		return requestors.stream().filter(check -> check.getUserName().equals(admin.getUserName()))
				.filter(check -> check.getPassword().equals(admin.getPassword())).findFirst().get();
	}

}