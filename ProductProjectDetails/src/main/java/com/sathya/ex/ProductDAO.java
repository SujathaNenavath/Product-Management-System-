package com.sathya.ex;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;



public class ProductDAO {
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	public int saveProduct(Product product) {
		
		Connection connection=DBConnection.createConnection();
		int result=0;
		try {
			PreparedStatement preparedstatement=connection.prepareStatement("insert into productdata values(?,?,?,?,?,?,?,?)");
			preparedstatement.setString(1, product.getPid());
			preparedstatement.setString(2, product.getPname());
			preparedstatement.setDouble(3, product.getPrice());
			preparedstatement.setString(4, product.getBrand());
			preparedstatement.setString(5, product.getMadein());
			preparedstatement.setDate(6, product.getManufacturingdate());
			preparedstatement.setDate(7, product.getExpirydate());
			preparedstatement.setBinaryStream(8, product.getProductimage());
			result=preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(connection!=null)
				connection.close();
			if(preparedstatement!=null)
				preparedstatement.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
		return result;
		
				
	}

	public List<Product> displayListOfProducts() throws ServletException {
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBConnection.createConnection();
        String sql = "SELECT * FROM productdata";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	Product product=new Product();
                product.setPid(resultSet.getString("pid"));
                product.setPname(resultSet.getString("pname"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBrand(resultSet.getString("brand"));
                product.setMadein(resultSet.getString("madein"));
                product.setManufacturingdate(resultSet.getDate("manufacturingdate"));
                product.setExpirydate(resultSet.getDate("expirydate"));
                
               product.setProductimage(resultSet.getBinaryStream("productimage"));
               productList.add(product);
            }
        } catch (SQLException e) {
            throw new ServletException("Database operation failed", e);
        }
        return productList;
    }

	public int deletebypid(String pid) {
		int result=0;
		Connection connection=DBConnection.createConnection();
		try {
			PreparedStatement preparedstatement=connection.prepareStatement("delete from productdata where pid=?");
			preparedstatement.setString(1,pid);
			result=preparedstatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Product getProductById(String pid) throws ServletException {
        Product product=null;
        Connection connection = DBConnection.createConnection();
        String sql = "SELECT * FROM productdata where pid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, pid);
        	ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
            	product =new Product();
                product.setPid(resultSet.getString("pid"));
                product.setPname(resultSet.getString("pname"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBrand(resultSet.getString("brand"));
                product.setMadein(resultSet.getString("madein"));
                product.setManufacturingdate(resultSet.getDate("manufacturingdate"));
                product.setExpirydate(resultSet.getDate("expirydate"));
                product.setProductimage(resultSet.getBinaryStream("productimage"));
               
            }
        } catch (SQLException e) {
            throw new ServletException("Database operation failed", e);
        }
        return product;
    }
	public int updateProduct(Product updatedProduct) {
	    int result = 0;
	        try(Connection connection = DBConnection.createConnection())
	        {
	             // SQL query to update product details
	            String sql = "UPDATE productdata SET pname=?, price=?, brand=?, madein=?, " +
	                    "manufacturingdate=?, expirydate=?, productimage=? WHERE pid=?";
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	                // Set the parameters for the update statement
	            preparedStatement.setString(1, updatedProduct.getPname());
	            preparedStatement.setDouble(2, updatedProduct.getPrice());
	            preparedStatement.setString(3, updatedProduct.getBrand());
	            preparedStatement.setString(4, updatedProduct.getMadein());
	            preparedStatement.setDate(5, updatedProduct.getManufacturingdate());
	            preparedStatement.setDate(6, updatedProduct.getExpirydate());
	            preparedStatement.setBinaryStream(7, updatedProduct.getProductimage());
	            preparedStatement.setString(8, updatedProduct.getPid());

	                // Execute the update
	                result = preparedStatement.executeUpdate();
	            }
	         catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return result;
	    }
}


