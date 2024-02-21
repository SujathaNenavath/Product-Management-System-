package com.sathya.ex;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UpdateServlet")
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
        String updatedpname = request.getParameter("pname");
        double updatedprice = Double.parseDouble(request.getParameter("price"));
        String updatedbrand = request.getParameter("brand");
        String updatedmadein = request.getParameter("madein");
        Date updatedmanufacturingdate = Date.valueOf(request.getParameter("manufacturingdate"));
        Date updatedexpirydate = Date.valueOf(request.getParameter("expirydate"));
       
       
        
        Product product = new Product();
	     product.setPid(pid);
	     product.setPname(updatedpname);
	     product.setPrice(updatedprice);
	     product.setBrand(updatedbrand);
	     product.setMadein(updatedmadein);
	     product.setManufacturingdate(updatedmanufacturingdate);
	     product.setExpirydate(updatedexpirydate);
	     
	     ProductDAO dao = new ProductDAO();
	
	    
	     Part newImagePart = request.getPart("productimage");
	     if (newImagePart != null && newImagePart.getSize() > 0) {
	            product.setProductimage(newImagePart.getInputStream());
	        } else {
	        	 Product existingproduct = dao.getProductById(pid);
	        	
	            product.setProductimage(existingproduct.getProductimage());
	        }
	        
	     
	  
	     int result = dao.updateProduct(product);
	
	     if(result == 1)
	     {  	RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
	        	dispatcher.forward(request, response);
	     }    
	}


	}


