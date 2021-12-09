package com.sboot.Ecom.model;

public class OrderDetails {
    private String prodName;
	private double prodPrice;
	private String prodImage;
	private int prodQuantity;
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public double getProdPrice() {
        return prodPrice;
    }
    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
    public String getProdImage() {
        return prodImage;
    }
    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }
    public int getProdQuantity() {
        return prodQuantity;
    }
    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }
    @Override
    public String toString() {
        return "OrderDetails [prodImage=" + prodImage + ", prodName=" + prodName + ", prodPrice=" + prodPrice
                + ", prodQuantity=" + prodQuantity + "]";
    }
    
}
