package com.estore.entity;

import java.sql.Date;

public class PurchaseReport {
	private String username;
	private String password;
	private String email;
	private String phonenumber;
	
	private String Season;
	private String Brand;
	private String category;
	private double price;
	private String color;
	private Date createdDate;
	private float discount;
	private String Productname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSeason() {
		return Season;
	}
	public void setSeason(String season) {
		Season = season;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	@Override
	public String toString() {
		return "PurchaseReport [username=" + username + ", password=" + password + ", email=" + email + ", phonenumber="
				+ phonenumber + ", Season=" + Season + ", Brand=" + Brand + ", category=" + category + ", price="
				+ price + ", color=" + color + ", createdDate=" + createdDate + ", discount=" + discount
				+ ", Productname=" + Productname + "]";
	}
	
	
	
}
