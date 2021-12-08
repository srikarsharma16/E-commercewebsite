package com.sboot.Ecom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Address {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
    private long prodId;
    private double price;
    private int quantity;
    private String country;
    private String fullName;
    private String mobileNumber;
    private String pinCode;
    private String houseNumber;
    private String landmark;
    private String city;
    private String state;
    private String addressType;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIdnull() {
        this.id = (Integer) null;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public long getProdId() {
        return prodId;
    }
    public void setProdId(long prodId) {
        this.prodId = prodId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public String getLandmark() {
        return landmark;
    }
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    @Override
    public String toString() {
        return "Address [addressType=" + addressType + ", city=" + city + ", country=" + country + ", customerId="
                + customerId + ", fullName=" + fullName + ", houseNumber=" + houseNumber + ", id=" + id + ", landmark="
                + landmark + ", mobileNumber=" + mobileNumber + ", pinCode=" + pinCode + ", price=" + price
                + ", prodId=" + prodId + ", quantity=" + quantity + ", state=" + state + "]";
    }

}

