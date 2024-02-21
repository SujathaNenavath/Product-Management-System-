package com.sathya.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		
		ProductDAO dao=new ProductDAO();
		Product existingproduct=dao.getProductById(pid);
		
		request.setAttribute("existingproduct", existingproduct);
		
		if(existingproduct!=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/editform.jsp");
			dispatcher.forward(request, response);
		}
	}
	
}
