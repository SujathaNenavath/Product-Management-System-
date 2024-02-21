package com.sathya.ex;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

public class Product {
	
	private String pid;
    private String pname;
    private double price;
    private String brand;
    private String madein;
    private Date manufacturingdate;
    private Date expirydate;
    private InputStream productimage;

    
	
	public String getBase64ProductImage(){
    	 try {
			return Base64.getEncoder().encodeToString(productimage.readAllBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
    		 
    	 
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getMadein() {
		return madein;
	}



	public void setMadein(String madein) {
		this.madein = madein;
	}



	public Date getManufacturingdate() {
		return manufacturingdate;
	}



	public void setManufacturingdate(Date manufacturingdate) {
		this.manufacturingdate = manufacturingdate;
	}



	public Date getExpirydate() {
		return expirydate;
	}



	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}



	public InputStream getProductimage() {
		return productimage;
	}



	public void setProductimage(InputStream productimage) {
		this.productimage = productimage;
	}



	
	
}

