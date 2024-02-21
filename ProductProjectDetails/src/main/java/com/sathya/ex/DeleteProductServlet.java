package com.sathya.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteProductServlet() {
        super();
       
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		ProductDAO dao=new ProductDAO();
	       int result= dao.deletebypid(pid);
	       //send the result to Jsp file
	       if(result==1) {
	      	 RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
	      	 dispatcher.forward(request, response);
	       }
	       else {
	      	 response.setContentType("text/html");
	      	 PrintWriter writer=response.getWriter();
	      	 writer.println("<center><b>product is not deleted check once</b></center");
	      	 RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
	      	 dispatcher.include(request, response);
	       }
	       }
}
