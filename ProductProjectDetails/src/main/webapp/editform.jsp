<%@page import="com.sathya.ex.ProductDAO"%>
<%@page import="com.sathya.ex.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update data</title>

     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   
</head>
<body>

   <div class="container mt-5 text-center">

		<h2 class="text-center font-italic mb-5">Update Product Data</h2>

    	<form method="post" action="./UpdateServlet" onsubmit="return validateForm()" enctype="multipart/form-data" >
        
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="pid">Product ID:</label>
                <input type="text" class="form-control-sm" value="${existingproduct.pid}" name="pid" required>
            </div>
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="pname">Product Name:</label>
                <input type="text" class="form-control-sm" value="${existingproduct.pname}" name="pname" required>
            </div>
            
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="price">Product price:</label>
                <input type="number" class="form-control-sm" value="${existingproduct.price}" name="price" step="0.01" required>
            </div>
            
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="brand">Brand:</label>
                <input type="text" class="form-control-sm" value="${existingproduct.brand}" name="brand" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="madein">Made In:</label>
                <input type="text" class="form-control-sm" value="${existingproduct.madein}" name="madein" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="manufacturingdate">Manufacturing Date:</label>
                <input type="date" class="form-control-sm" value="${existingproduct.manufacturingdate}" name="manufacturingdate" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="expirydate">Expiry Date:</label>
                <input type="date" class="form-control-sm" value="${existingproduct.expirydate}" name="expirydate" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="productimage">Product Image:</label>
                <input type="file" class="form-control-file-sm" value="${existingproduct.productimage}" name="productimage" accept="image/*" required>
            </div>

          <div class="form-group">
         	<input type="submit" class="btn btn-success" class="form-control-file-sm" value="Update product"/>
         	<a onclick="window.location.href='productList.jsp'"></a>
        </div>
            
        </form>
    </div>
</body>
</html>