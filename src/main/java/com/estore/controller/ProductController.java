package com.estore.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.estore.entity.ProductModel;
import com.estore.entity.PurchaseReport;
import com.estore.entity.UserModel;
import com.estore.service.ProductService;

@RestController
@RequestMapping(value = "/product")

public class ProductController {
	@Autowired
	ProductService productservice;

	@PostMapping("/addProduct")

	public @ResponseBody String addProduct(@RequestBody ProductModel product) {
		int addstatus = productservice.addProduct(product);
		if (addstatus > 0) {
			return "Product added successfully!";
		} else {
			return "Fail to add product";
		}

	}

	@DeleteMapping("/deleteProduct/{productid}")

	public @ResponseBody String deleteProduct(@PathVariable int productid) {
		int addstatus = productservice.deleteProduct(productid);
		if (addstatus > 0) {
			return "Product deleted successfully!";
		} else {
			return "Fail to delete product";
		}

	}
	
	@PutMapping("/updateProduct/{productid}")
	public @ResponseBody String updateProduct(@PathVariable int productid,@RequestBody ProductModel product) {
		int addstatus = productservice.updateProduct(productid,product);
		if (addstatus > 0) {
			return "Product updated successfully!";
		} else {
			return "Fail to updated product";
		}

	}
	
	@GetMapping("/getProductBySearch/{productid}/{season}/{brand}/{category}/{price}/{color}/{date}")
	public @ResponseBody ArrayList<ProductModel> getProductBySearch(@PathVariable int productid,@PathVariable String season,
			@PathVariable String brand,@PathVariable String category,@PathVariable Double price,
			@PathVariable String color,@PathVariable Date date) {
		ArrayList<ProductModel> addstatus = productservice.getProductBySearch(productid,season,brand,category,price,color,date);
		if (addstatus != null) {
			return addstatus;
		}
		return addstatus; 

	}
	
	@GetMapping("/getAllUsers")
	public @ResponseBody ArrayList<UserModel> getAllUsers() {
		ArrayList<UserModel> addstatus = productservice.getAllUsers();
		if (addstatus != null) {
			return addstatus;
		}
		return addstatus; 

	}
	
	@GetMapping("/getAllUsersAndProductPurchased")
	public @ResponseBody ArrayList<PurchaseReport> getAllUsersAndProductPurchased() {
		ArrayList<PurchaseReport> addstatus = productservice.getAllUsersAndProductPurchased();
		if (addstatus != null) {
			return addstatus;
		}
		return addstatus; 

	}
	

}
