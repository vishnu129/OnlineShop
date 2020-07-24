<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
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
<tr><td><h1>Add Customer</h1></td></tr>

	
<form action="addcustomer" >
<tr><td>	Enter Customer id: <input type="text" name="customer_id" required></td></tr>
 <tr><td>   Enter Customer name: <input type="text" name="customer_name" required></td></tr>
 <tr><td>   Enter Wallet Amount: <input type="text" name="wallet" required></td></tr>
 <tr></tr>
<tr><td><input type="submit" name="btn" value="Add Customer" style="height:30px;width:150px; font-size:20px"></td></tr> 
</form> 
</table>
</body>

</html>