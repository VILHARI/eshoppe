package com.estore.entity;

import java.sql.Date;

public class ProductModel {
	private String Season;
	private String Brand;
	private String category;
	private double price;
	private String color;
	private Date createdDate;
	private float discount;
	private int Productid;
	private String Productname;
	private int quantity;
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
	public int getProductid() {
		return Productid;
	}
	public void setProductid(int productid) {
		Productid = productid;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductModel [Season=" + Season + ", Brand=" + Brand + ", category=" + category + ", price=" + price
				+ ", color=" + color + ", createdDate=" + createdDate + ", discount=" + discount + ", Productid="
				+ Productid + ", Productname=" + Productname + ", quantity=" + quantity + "]";
	}
	
	

}
