<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<style type="text/css">
table, th, td {
border:px solid black;
width:100%;
text-align:center;
}
</style>
</head>
<body bgcolor="#BEEDBA">

<table>
<tr><td><br></td></tr>
<tr><td><br></td></tr>

<tr><td><br></td></tr>
<tr><td><h1>Add Product</h1></td></tr>

	
<form action="addproduct" >
<tr><td>	Enter Product id: <input type="text" name="product_id" required></td></tr>
 <tr><td>   Enter Product name: <input type="text" name="product_name" required></td></tr>
 <tr><td>   Enter Product price: <input type="text" name="product_cost" required></td></tr>
 <tr><td>   Enter Product quantity: <input type="text" name="quantity" required></td></tr>
 <tr><td>   Enter Product discount: <input type="text" name="discount" required></td></tr>
 <tr></tr>
<tr><td><input type="submit" name="btn" value="Add Product" style="height:30px;width:150px; font-size:20px"></td></tr> 
</form> 
</table>
</body>

</html>