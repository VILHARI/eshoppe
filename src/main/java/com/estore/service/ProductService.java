package com.estore.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.estore.entity.ProductModel;
import com.estore.entity.PurchaseReport;
import com.estore.entity.UserModel;

@Component
public interface ProductService {

	int addProduct(ProductModel product);

	int deleteProduct(int productid);

	int updateProduct(int productid, ProductModel product);

	ArrayList<ProductModel> getProductBySearch(int productid, String season, String brand, String category, Double price, String color,
			Date date);

	ArrayList<UserModel> getAllUsers();

	ArrayList<PurchaseReport> getAllUsersAndProductPurchased();

}
