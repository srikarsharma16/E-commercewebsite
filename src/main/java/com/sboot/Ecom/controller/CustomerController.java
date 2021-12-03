package com.sboot.Ecom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sboot.Ecom.model.Customer;
import com.sboot.Ecom.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/{Id}")
	public Optional<Customer> getCustomerById(@PathVariable long Id){
		
		Optional<Customer> customer=customerService.getCustomerById(Id);
		
		return customer;
	}
	
	@PostMapping("/customer")
	public void doAddCustomer(Customer customer) {
		
		customerService.add(customer);
		
	}
	
	@GetMapping("/editCustomer/{id}")
	public ModelAndView getEditCustomerDetails(@PathVariable long id) {
		
		ModelAndView modelAndView =new ModelAndView("editCustomer");
		
		Optional<Customer> customer=customerService.getCustomerById(id);
		
		modelAndView.addObject("customer", customer);
		
		return modelAndView;
	}

	@PostMapping("/editCustomer")
	public String doEditCustomer(Customer customer) {
		
		long cust_id=customer.getCustId();
		String name=customer.getCustName();
		String email=customer.getCustEmail();
		String mobile=customer.getCustMobile();
		String address=customer.getCustAddress();
		customerService.adminCustEdit(cust_id,name,email,mobile,address);

		
		return "redirect:/customerDetails";
		
	}
	
	@GetMapping("/deleteCustomer/{Id}")
	public String doDeleteCustomer(@PathVariable long Id) {
		
		customerService.delete(Id);
		
		return "redirect:/customerDetails";
		
	}
}
