package com.sboot.Ecom.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sboot.Ecom.dao.ProductRepository;
import com.sboot.Ecom.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> getProductById(long id) {
		
		Optional<Product> productbyid=productRepository.findById(id);
		
		return productbyid;
	}


	public List<Product> getAllProducts() {
		
		List<Product> product = productRepository.findAll();
		
		return product;
	}


	public void add(Product product) {
		
		productRepository.save(product);
		
	}


	public void edit(Product product, long l) {
		
		long prodId=l;
		String prodName=product.getProdName();
		String prodDesc=product.getProdDesc();
		double prodPrice=product.getProdPrice();
		double prodDiscount=product.getProdDiscount();
		productRepository.doupdate(prodId,prodName,prodDesc,prodPrice,prodDiscount);
		//productRepository.save(product);
		
	}


	public void delete(long id) {
		
		productRepository.deleteById(id);
		
	}


	public void saveProductToDB(MultipartFile file, String name, String desc, double price, double discount) {
		
		Product p = new Product();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			
			p.setProdImage(Base64.getEncoder().encodeToString(file.getBytes()));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		p.setProdDesc(desc);
		
        p.setProdName(name);
        
        p.setProdPrice(price);
        
        p.setProdDiscount(discount);
       
        productRepository.save(p);
	}

	public void adminProdEdit(long prodId, String prodName, String prodDesc, Double prodPrice, Double prodDiscount) {
		productRepository.adminProdEdit(prodId,prodName,prodDesc,prodPrice,prodDiscount);
		
	}

	
}
