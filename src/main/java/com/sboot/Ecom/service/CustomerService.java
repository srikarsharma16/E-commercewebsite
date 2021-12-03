package com.sboot.Ecom.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sboot.Ecom.dao.CartRepository;
import com.sboot.Ecom.dao.CustomerRepository;
import com.sboot.Ecom.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CartRepository cartRepository;
	
	public Optional<Customer> getCustomerById(long Id) {

		Optional<Customer> customer = customerRepository.findById(Id);

		return customer;

	}
	

	public List<Customer> getAllCustomers() {

		List<Customer> customer = customerRepository.findAll();

		return customer;
		
	}

	public void add(Customer customer) {
		
		customerRepository.save(customer);
		
	}

	public void edit(Customer customer, long l) {
		
		long cust_id=l;
		String name=customer.getCustName();
		String email=customer.getCustEmail();
		String mobile=customer.getCustMobile();
		String address=customer.getCustAddress();
		customerRepository.doupdate(cust_id,name,email,mobile,address);
	}

	public void delete(long id) {
		
		cartRepository.delByCustId(id);
		customerRepository.delByCustId(id);
		
	}

	public boolean validate(Customer customer) {

		String email = customer.getCustEmail();
		String password = customer.getCustPassword();

		for (Customer customer1 : customerRepository.findAll()) {

			if (customer1.getCustEmail().equals(email) && customer1.getCustPassword().equals(password)) {
				customer.setCustId(customer1.getCustId());
				return true;
			}
		}

		return false;
	}


	public void adminCustEdit(long cust_id, String name, String email, String mobile, String address) {
		customerRepository.adminCustEdit(cust_id,name,email,mobile,address);
		
	}
}
