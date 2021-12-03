package com.sboot.Ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sboot.Ecom.model.Admin;
import com.sboot.Ecom.model.Customer;
import com.sboot.Ecom.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/admin")
	public List<Admin> getAdminDetails(){
		
		List<Admin> admin=adminService.getAdminDetails();
		return admin;
	}
	
	@GetMapping("/adminLogin")
	public ModelAndView getAdminLoginPage() {
		ModelAndView modelAndView =new ModelAndView("adminLogin");
		
		return modelAndView;
	}
	
	@PostMapping("/adminLogin")
	public String doAdminLogin(Admin admin) {
		
		boolean isLogin = adminService.validate(admin);
		System.out.println(isLogin);
		if(isLogin) {
			return "redirect:/addProduct";
		}
		else {
			return "redirect:/adminLogin";
		}
	}
	

}
