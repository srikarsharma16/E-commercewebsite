package com.sboot.Ecom.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sboot.Ecom.model.Cart;
import com.sboot.Ecom.model.Customer;
import com.sboot.Ecom.model.Product;
import com.sboot.Ecom.service.CartService;
import com.sboot.Ecom.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/cart/{Id}")
	public ModelAndView getCartItemsById(@PathVariable long Id) {
		ModelAndView modelAndView =new ModelAndView("dashboard");
		
		return modelAndView;
	}
	
	@PostMapping("/cart")
	public String doregistration(Cart cart) {
		
		cartService.add(cart);
		
		return "redirect:/mycart";
	}
	
	@PostMapping("/deleteFromCart")
	public String doDeleteFromCart(Cart cart) {
		
		cartService.deleteByCustAndProdId(cart);
		
		return "redirect:/mycart";
	}
	
}
