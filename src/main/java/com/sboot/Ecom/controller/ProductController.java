package com.sboot.Ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sboot.Ecom.global.Globaldata;
import com.sboot.Ecom.model.Product;
import com.sboot.Ecom.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public List<Product> getAllProducts() {

		 List<Product> product=productService.getAllProducts();

		return product;
	}

	@GetMapping("/product/{Id}")
	public Optional<Product> getProductById(@PathVariable long Id) {

		Optional<Product> productbyid=productService.getProductById(Id);

		return productbyid;
	}

	@GetMapping("/viewProducts")
	public ModelAndView getdashboardPage() {
		ModelAndView modelAndView =new ModelAndView("viewProducts");
		
		List<Product> allProducts=productService.getAllProducts();
		
		modelAndView.addObject("allProducts",allProducts);
		
		return modelAndView;
	}

	
	@PostMapping("/addP")
	    public String saveProduct(@RequestParam("file") MultipartFile file,
	    		@RequestParam("pname") String name,
	    		@RequestParam("price") double price,
	    		@RequestParam("desc") String desc,
	    		@RequestParam("discount") double discount)
	    {
	    	productService.saveProductToDB(file, name, desc, price,discount);
	    	return "redirect:/customerDetails";
	    }

	@GetMapping("/editProduct/{id}")
	public ModelAndView getEditProductDetails(@PathVariable long id) {
		
		ModelAndView modelAndView =new ModelAndView("editProduct");
		
		Optional<Product> product=productService.getProductById(id);
		
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	 
	@PostMapping("/editProduct")
	public String doEditProduct(Product product) {

		long prodId=product.getProdId();
		String prodName=product.getProdName();
		String prodDesc=product.getProdDesc();
		double prodPrice=product.getProdPrice();
		double prodDiscount=product.getProdDiscount();
		productService.adminProdEdit(prodId,prodName,prodDesc,prodPrice,prodDiscount);

		
		return "redirect:/viewProducts";

		//productService.edit(product);

	}
	
	@GetMapping("/deleteProduct/{Id}")
	public String deDeleteProduct(@PathVariable long Id) {
		
		productService.delete(Id);
		return "redirect:/viewProducts";
	}

	@GetMapping("/checkout/{prodId}")
	public ModelAndView fetchProductBy(@PathVariable long prodId){

		ModelAndView modelAndView = new ModelAndView("BuyNowDetails");
		Globaldata.prod_id=prodId;
		Product product = productService.getProductById(prodId).get();
		
		modelAndView.addObject("product",product);

		return modelAndView;
	}
}
