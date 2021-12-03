package com.sboot.Ecom.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prodId")
	private long prodId;
	
	private String prodName;
	private String prodDesc;
	private double prodPrice;
	private double prodDiscount;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String prodImage;
	
	@OneToMany(targetEntity = Cart.class,cascade = CascadeType.ALL)
	@JoinColumn(name="prod_Id",referencedColumnName = "prodId")
	private List<Cart> cart;

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public double getProdDiscount() {
		return prodDiscount;
	}

	public void setProdDiscount(double prodDiscount) {
		this.prodDiscount = prodDiscount;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodPrice="
				+ prodPrice + ", prodDiscount=" + prodDiscount + ", prodImage=" + prodImage + "]";
	}

		
}