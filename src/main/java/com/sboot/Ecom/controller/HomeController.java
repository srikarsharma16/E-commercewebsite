package com.sboot.Ecom.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sboot.Ecom.model.Admin;
import com.sboot.Ecom.model.Cart;
import com.sboot.Ecom.model.CartProduct;
import com.sboot.Ecom.model.Customer;
import com.sboot.Ecom.model.Product;
import com.sboot.Ecom.service.AdminService;
import com.sboot.Ecom.service.CartService;
import com.sboot.Ecom.service.CustomerService;
import com.sboot.Ecom.service.ProductService;

import com.sboot.Ecom.global.Globaldata;

@Controller
public class HomeController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	List<Product> prod_id;
	
	double Total;
	int numberOfItems;
	double finalAmount;
	
	
	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView modelAndView =new ModelAndView("index");
		
		return modelAndView;
	}

	
	@GetMapping("/adminLogout")
	public ModelAndView getLogoutPage() {
		ModelAndView modelAndView =new ModelAndView("adminLogin");
		
		return modelAndView;
	}
	
	
	@PostMapping("/login")
	public String doLogin(Customer customer,HttpSession session) {
		
		boolean isLogin = customerService.validate(customer);
		
		long id=customer.getCustId();
		if(isLogin) {
			session.setAttribute("id", id);
			return "redirect:/userIndex";
		}
		else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/profile/{id}")
	public ModelAndView getCustomerDetails(@PathVariable long id) {
		
		ModelAndView modelAndView =new ModelAndView("viewProfile");
		
		Optional<Customer> customer=customerService.getCustomerById(id);
		Customer c=customer.get();
		
		modelAndView.addObject("custId",c.getCustId());
		modelAndView.addObject("custName",c.getCustName());
		modelAndView.addObject("custEmail",c.getCustEmail());
		modelAndView.addObject("custMobile",c.getCustMobile());
		modelAndView.addObject("custAddress",c.getCustAddress());
		return modelAndView;
	}
	
	@GetMapping("/updateProfile/{id}")
	public ModelAndView getUpdateDetails(@PathVariable long id) {
		
		ModelAndView modelAndView =new ModelAndView("updateProfile");
		
		Optional<Customer> customer=customerService.getCustomerById(id);
		Customer c=customer.get();
		
		modelAndView.addObject("custId",c.getCustId());
		modelAndView.addObject("custName",c.getCustName());
		modelAndView.addObject("custEmail",c.getCustEmail());
		modelAndView.addObject("custMobile",c.getCustMobile());
		modelAndView.addObject("custAddress",c.getCustAddress());
		
		return modelAndView;
	}
	
	
	@PostMapping("/updateProfile")
	public String doUpdate(Customer customer,HttpSession session) {
		
		customerService.edit(customer,(long)session.getAttribute("id"));
		
		return "redirect:/userIndex";
	}
	
	@GetMapping("/payment")
	public ModelAndView doPayment(Customer customer) {
		
		ModelAndView modelAndView =new ModelAndView("payment");
		
		return modelAndView;
	}
	
	@GetMapping("/paymentSuccessfull")
	public ModelAndView doPaymentSuccessfull(Customer customer) {
		
		ModelAndView modelAndView =new ModelAndView("paymentSuccessfull");
		
		return modelAndView;
	}
	
	@GetMapping("/logout")
	public ModelAndView doLogout(Customer customer) {
		
		ModelAndView modelAndView =new ModelAndView("logout");
		
		return modelAndView;
	}
		
	@PostMapping("/register")
	public String doregistration(Customer customer) {
		
		customerService.add(customer);
		
		return "redirect:/login";
	}
	

	@GetMapping("/dashboard")
	public ModelAndView getdashboardPage() {
		ModelAndView modelAndView =new ModelAndView("dashboard");
		
		List<Product> allProducts=productService.getAllProducts();
		Optional<Product> p=productService.getProductById(1);
		
		modelAndView.addObject("allProducts",allProducts);
		modelAndView.addObject("p",p);
		
		return modelAndView;
	}
	@GetMapping("/userIndex")
	public ModelAndView getUserIndex() {
		ModelAndView modelAndView =new ModelAndView("userIndex");
		
		List<Product> allProducts=productService.getAllProducts();
		Optional<Product> p=productService.getProductById(1);
		
		modelAndView.addObject("allProducts",allProducts);
		modelAndView.addObject("p",p);
		
		return modelAndView;
	}

	@GetMapping("/productDashboard")
	public ModelAndView getproductDashboard() {
		ModelAndView modelAndView = new ModelAndView("productDashboard");

		List<Product> allProducts=productService.getAllProducts();
		Optional<Product> p=productService.getProductById(1);
		
		modelAndView.addObject("allProducts",allProducts);
		modelAndView.addObject("p",p);
		
		return modelAndView;

	}

	@GetMapping("/singleProduct/{id}")
	public ModelAndView getsingleProduct(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView("single-product");

		//List<Product> allProducts=productService.getAllProducts();
		Product productbyid=productService.getProductById(id).get();
		
		modelAndView.addObject("productbyid", productbyid);
		//modelAndView.addObject("allProducts",allProducts);
		return modelAndView;

	}

	
	//New
	
	@GetMapping("/mycart")
	public ModelAndView getCartPage(HttpSession session) {
		ModelAndView modelAndView =new ModelAndView("cart");
		
		Globaldata.cartProducts.clear();
		try {
			
		long custId=(long) session.getAttribute("id");
		
		Optional<List<Cart>> prod=cartService.getCartItemsByCustId(custId);
		List<Cart> car=prod.get();
		long prod11;
		
		for(Cart cart:car) {
			prod11=cart.getProdId();
			CartProduct c =new CartProduct();
			Product p=new Product();
			p=productService.getProductById(prod11).get();
			c.setProdId(p.getProdId());
			c.setProdName(p.getProdName());
			c.setProdPrice(p.getProdPrice());
			c.setProdDiscount(p.getProdDiscount());
			c.setProdDesc(p.getProdDesc());
			c.setProdImage(p.getProdImage());
			//c.setGst(p.getGst());
			c.setProdQuantity(cart.getProdquantity());
			Globaldata.cartProducts.add(c);
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		Total=0;
		numberOfItems=0;
		finalAmount=0;
		getTotalOfProducts(Globaldata.cartProducts);
		modelAndView.addObject("allCart", Globaldata.cartProducts);
		modelAndView.addObject("Total", Total);
		modelAndView.addObject("numberOfItems", numberOfItems);
		modelAndView.addObject("finalAmount", finalAmount);
		return modelAndView;
	}
	
	//New
	
	private void getTotalOfProducts(List<CartProduct> product) {
		
		for(CartProduct p:product) {
			numberOfItems=numberOfItems+p.getProdQuantity();
			Total=Total+((p.getProdPrice()*(p.getProdDiscount()/100))*p.getProdQuantity());
			finalAmount=finalAmount+((p.getProdPrice()-(p.getProdPrice()*(p.getProdDiscount()/100)))*p.getProdQuantity());
		}
	}

	//New

	@GetMapping("/updateQuantity/{quantity}/{prod_id}")
	public String getUpdatedQuantity(@PathVariable int quantity,@PathVariable long prod_id,HttpSession session ){
		
		cartService.doUpdateQuantity(quantity,prod_id,(long)session.getAttribute("id"));

		return "redirect:/mycart";
	}

	@GetMapping("/addProduct")
	public ModelAndView getAddProductPage() {
		
		ModelAndView modelAndView =new ModelAndView("addProduct");
		
		return modelAndView;
	}
	
	@GetMapping("/customerDetails")
	public ModelAndView getCustomerDetailsPage() {
		
		ModelAndView modelAndView =new ModelAndView("customerDetails");
		
		List<Customer> allCustomers=customerService.getAllCustomers();
		
		modelAndView.addObject("allCustomers",allCustomers);
		
		
		return modelAndView;
	}
	
	@PostMapping("/addProducts")
	public String addProducts(Product product) {
		
		productService.add(product);
		
		return "redirect:/dashboard";
	}

	@GetMapping("/contactUs")
	public ModelAndView getContactUs() {
		ModelAndView modelAndView=new ModelAndView("contact");

		return modelAndView;
	}

	@GetMapping("/aboutPage")
	public ModelAndView getAboutPage() {
		ModelAndView modelAndView=new ModelAndView("about");

		return modelAndView;
	}

	//New

	@GetMapping("/buyCartItems")
	public ModelAndView goToBilling(){
		ModelAndView modelAndView = new ModelAndView("checkout");

		Customer customer=Globaldata.customerDetails.get(0);
		modelAndView.addObject("CustomerDetails",customer);
		modelAndView.addObject("numberOfItems", numberOfItems);
		modelAndView.addObject("finalAmount", finalAmount);

		return modelAndView;
	}

	//New

	@GetMapping("/buyItem/{quantity}/{prod_id}")
	public ModelAndView sendItemToBilling(@PathVariable int quantity,@PathVariable long prod_id){
		ModelAndView modelAndView = new ModelAndView("checkout");

		Customer customer=Globaldata.customerDetails.get(0);
		Product p=productService.getProductById(prod_id).get();
		double total=quantity*(p.getProdPrice()-(p.getProdPrice()*(p.getProdDiscount()/100)));
		modelAndView.addObject("CustomerDetails",customer);
		modelAndView.addObject("numberOfItems", quantity);
		modelAndView.addObject("finalAmount", total);

		return modelAndView;
	}
}
