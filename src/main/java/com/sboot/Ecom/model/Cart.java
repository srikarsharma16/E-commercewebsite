package com.sboot.Ecom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(Cart.class)
public class Cart implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;

	@Id
	@Column(name="cust_Id")
	private long custId;
	
	@Id
	@Column(name="prod_Id")
	private long prodId;

	private int prodquantity;
	
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public int getProdquantity() {
		return prodquantity;
	}
	public void setProdquantity(int prodquantity) {
		this.prodquantity = prodquantity;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", custId=" + custId + ", prodId=" + prodId + ", prodquantity=" + prodquantity
				+ "]";
	}
	
	
	
}
