package com.sboot.Ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sboot.Ecom.dao.AdminRepository;
import com.sboot.Ecom.model.Admin;
import com.sboot.Ecom.model.Customer;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAdminDetails() {
		List<Admin> admindetails=adminRepository.findAll();
		return admindetails;
	}
	
	public boolean validate(Admin admin) {

		String name = admin.getAdminName();
		String password = admin.getAdminPassword();

		for (Admin admin1 : adminRepository.findAll()) {
			
			if (admin1.getAdminName().equals(name) && admin1.getAdminPassword().equals(password)) {
				return true;
			}
		}

		return false;
	}


}
