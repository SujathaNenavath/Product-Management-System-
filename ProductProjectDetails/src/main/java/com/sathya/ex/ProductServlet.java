package com.sathya.ex;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
        String pname = request.getParameter("pname");
        double price = Double.parseDouble(request.getParameter("price"));
        String brand = request.getParameter("brand");
        String madein = request.getParameter("madein");
        Date manufacturingdate = Date.valueOf(request.getParameter("manufacturingdate"));
        Date expirydate = Date.valueOf(request.getParameter("expirydate"));

        //input stream of the upload file (product image)
        Part image = request.getPart("productimage");
        InputStream  imageInputStream= image.getInputStream();
        
        
        Product product=new Product();
        product.setPid(pid);
        product.setPname(pname);
        product.setPrice(price);
        product.setBrand(brand);
        product.setMadein(madein);
        product.setManufacturingdate(manufacturingdate);
        product.setExpirydate(expirydate);
        product.setProductimage(imageInputStream);
        
        
      ProductDAO dao=new ProductDAO();
     int result= dao.saveProduct(product);
    //request.setAttribute("result",result );
     if(result==1) {
    	 RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
    	 dispatcher.forward(request, response);
     }
     else {
    	 response.setContentType("text/html");
    	 PrintWriter writer=response.getWriter();
    	 writer.println("<center><b>product is not saved check once</b></center");
    	 RequestDispatcher dispatcher=request.getRequestDispatcher("form.html");
    	 dispatcher.include(request, response);
     }

	}
        }
    

    
        

		       

		
	
	

	



