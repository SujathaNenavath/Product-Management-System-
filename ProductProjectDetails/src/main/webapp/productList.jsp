<%@page import="com.sathya.ex.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>List of Product</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
table{border-collapse:collapse;}
table,td,th{border:1px solid black;}
</style>
</head>

<body>
<center>
<h1>List of Products</h1>

<a class="btn btn-success mt-5" href="form.html">
  			  Save Product
</a>

<table class="table table-bordered table-striped">
    <thead class="thead-dark">
        <tr>
            <th>pid</th>
            <th>pname</th>
            <th>price</th>
            <th>brand</th>
            <th>madein</th>
            <th>manufacturingdate</th>
            <th>ExDate</th>
            <th>ProImage</th>
            <th>Actions</th>
        </tr>
    </thead>
	    
    <tbody>
        <c:forEach var="product" 
        	items="<%=new ProductDAO().displayListOfProducts()%>">
            <tr>
                <td>${product.pid}</td>
                <td>${product.pname}</td>
                <td>${product.price}</td>
                <td>${product.brand}</td>
                <td>${product.madein}</td>
                <td>${product.manufacturingdate}</td>
                <td>${product.expirydate}</td>           
                <td>
   			<img src="data:image/jpeg;base64,${product.base64ProductImage}" alt="Product Image" style="max-width: 100px; max-height: 100px;">
				</td>

                <td>
                   <a href="./DeleteProductServlet?pid=${product.pid}">Delete</a>
                   <a href="./EditProductServlet?pid=${product.pid}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</center>
</body>
</html>