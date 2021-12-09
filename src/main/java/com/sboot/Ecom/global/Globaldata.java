package com.sboot.Ecom.global;

import java.util.ArrayList;
import java.util.List;

import com.sboot.Ecom.model.Product;
import com.sboot.Ecom.model.Address;
import com.sboot.Ecom.model.CartProduct;
import com.sboot.Ecom.model.Customer;
import com.sboot.Ecom.model.OrderDetails;

public class Globaldata {

	public static List<Product> cart;
	
	static {
		cart=new ArrayList<Product>();
	}

	public static List<OrderDetails> order;
	static{
		order=new ArrayList<OrderDetails>();
	}

	public static List<CartProduct> cartProducts;
	public static List<Customer> customerDetails;
	public static List<CartProduct> tempCartProduct;
	public static int quantity;
	public static int i;
	public static long prod_id;
	public static double total;
	public static Address address;
	static {
		address=new Address();
	}
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
