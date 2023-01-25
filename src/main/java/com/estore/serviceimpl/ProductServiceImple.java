package com.estore.serviceimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.entity.ProductModel;
import com.estore.entity.PurchaseReport;
import com.estore.entity.UserModel;
import com.estore.service.ProductService;

@Service
public class ProductServiceImple implements ProductService {
	@Autowired
	private DataSource dataSource;

	@Override
	public int addProduct(ProductModel product) {

		Connection connection = null;
		String query = "call addProduct (?,?,?,?,?,?,?,?,?);";
		CallableStatement callableStatement = null;

		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, product.getQuantity());
			callableStatement.setString(2, product.getBrand());
			callableStatement.setString(3, product.getCategory());
			callableStatement.setString(4, product.getColor());
			callableStatement.setString(5, product.getProductname());
			callableStatement.setString(6, product.getSeason());
			callableStatement.setDouble(7, product.getPrice());
			callableStatement.setFloat(8, product.getDiscount());
			callableStatement.setDate(9, product.getCreatedDate());
			return callableStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				callableStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return 0;

	}

	@Override
	public int deleteProduct(int productid) {

		Connection connection = null;
		String query = "call deleteProduct (?);";
		CallableStatement callableStatement = null;

		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, productid);

			return callableStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				callableStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return 0;

	}

	@Override
	public int updateProduct(int productid, ProductModel product) {

		Connection connection = null;
		String query = "call updateProduct (?,?,?,?,?,?,?,?,?,?);";
		CallableStatement callableStatement = null;

		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, product.getQuantity());
			callableStatement.setString(2, product.getBrand());
			callableStatement.setString(3, product.getCategory());
			callableStatement.setString(4, product.getColor());
			callableStatement.setString(5, product.getProductname());
			callableStatement.setString(6, product.getSeason());
			callableStatement.setDouble(7, product.getPrice());
			callableStatement.setFloat(8, product.getDiscount());
			callableStatement.setDate(9, product.getCreatedDate());
			callableStatement.setInt(10, productid);
			return callableStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				callableStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return 0;

	}

	@Override
	public ArrayList<ProductModel> getProductBySearch(int productid, String season, String brand, String category,
			Double price, String color, Date date) {

		Connection connection = null;
		String query = "call getProductBySearch (?,?,?,?,?,?,?);";
		CallableStatement callableStatement = null;
		ArrayList<ProductModel> al = new ArrayList<ProductModel>();
		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, productid);
			callableStatement.setString(2, season);
			callableStatement.setString(3, brand);
			callableStatement.setString(4, category);
			callableStatement.setDouble(5, price);
			callableStatement.setString(6, color);
			callableStatement.setDate(7, date);
			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {

				ProductModel pd = new ProductModel();
				pd.setBrand(rs.getString("brand"));
				pd.setCategory(rs.getString("category"));
				pd.setColor(rs.getString("color"));
				pd.setCreatedDate(rs.getDate("createdDate"));
				pd.setDiscount(rs.getFloat("discount"));
				pd.setPrice(rs.getDouble("price"));
				pd.setProductid(rs.getInt("productid"));
				pd.setProductname(rs.getString("productname"));
				pd.setQuantity(rs.getInt("quantity"));
				pd.setSeason(rs.getString("season"));
				al.add(pd);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				callableStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return al;

	}

	@Override
	public ArrayList<UserModel> getAllUsers() {

		Connection connection = null;
		String query = "call getAllUsers ();";
		CallableStatement callableStatement = null;
		ArrayList<UserModel> al = new ArrayList<UserModel>();
		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(query);

			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {
				UserModel ud = new UserModel();
				ud.setEmail(rs.getString("email"));
				ud.setPassword(rs.getString("password"));
				ud.setPhonenumber(rs.getString("phoneNumber"));
				ud.setUserid(rs.getInt("userId"));
				ud.setUsername(rs.getString("username"));

				al.add(ud);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				callableStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return al;

	}

	@Override
	public ArrayList<PurchaseReport> getAllUsersAndProductPurchased() {


		Connection connection = null;
		String query = "call getPurchanseReport ();";
		CallableStatement callableStatement = null;
		ArrayList<PurchaseReport> al = new ArrayList<PurchaseReport>();
		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(query);

			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {
				PurchaseReport pr = new PurchaseReport();
				pr.setEmail(rs.getString("email"));
				pr.setPassword(rs.getString("password"));
				pr.setPhonenumber(rs.getString("phoneNumber"));
				pr.setUsername(rs.getString("username"));
				
				pr.setBrand(rs.getString("brand"));
				pr.setCategory(rs.getString("category"));
				pr.setColor(rs.getString("color"));
				pr.setCreatedDate(rs.getDate("createdDate"));
				pr.setDiscount(rs.getFloat("discount"));
				pr.setPrice(rs.getDouble("price"));
				pr.setProductname(rs.getString("productname"));
				pr.setSeason(rs.getString("season"));

				al.add(pr);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				callableStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return al;

	
	}

}
