package com.sboot.Ecom.global;

import java.util.ArrayList;
import java.util.List;

import com.sboot.Ecom.model.Product;

public class Globaldata {

	public static List<Product> cart;
	
	static {
		cart=new ArrayList<Product>();
	}
}
