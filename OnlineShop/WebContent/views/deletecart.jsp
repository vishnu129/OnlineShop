<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
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
<tr><td><h1>Remove Product from cart</h1></td></tr>

	
<form action="deletecart" >
<tr><td>	Enter Product id: <input type="text" name="id" required></td></tr>
<tr><td> <br> </td></tr>
<tr><td><input type="submit" name="btn"  value="Remove" style="height:30px;width:100px; font-size:20px"></td></tr> 
</form> 
</table>
</body>

</html>