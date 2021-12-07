package com.sboot.Ecom.global;

import java.util.ArrayList;
import java.util.List;

import com.sboot.Ecom.model.Product;


import com.sboot.Ecom.model.CartProduct;
import com.sboot.Ecom.model.Customer;

public class Globaldata {

	public static List<Product> cart;
	
	static {
		cart=new ArrayList<Product>();
	}

	public static List<CartProduct> cartProducts;
	public static List<Customer> customerDetails;
	public static List<CartProduct> tempCartProduct;
	
	static {
		cartProducts=new ArrayList<CartProduct>();
	}

	static{
		customerDetails=new ArrayList<Customer>();
	}

	static{
		tempCartProduct=new ArrayList<CartProduct>();
	}
}
