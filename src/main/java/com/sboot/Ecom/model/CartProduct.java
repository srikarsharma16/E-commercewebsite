package com.sboot.Ecom.model;


public class CartProduct {
	
	
	private long prodId;
	
	private String prodName;
	private String prodDesc;
	private double prodPrice;
	private double prodDiscount;
	private double gst;
	private String prodImage;
	private int prodQuantity;


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

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}
	

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	@Override
	public String toString() {
		return "CartProduct [gst=" + gst + ", prodDesc=" + prodDesc + ", prodDiscount=" + prodDiscount + ", prodId="
				+ prodId + ", prodImage=" + prodImage + ", prodName=" + prodName + ", prodPrice=" + prodPrice
				+ ", prodQuantity=" + prodQuantity + "]";
	}

	
	

		
}