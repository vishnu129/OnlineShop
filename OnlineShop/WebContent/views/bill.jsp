<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<style type="text/css">
table, th, td {
border:1px solid black;
border-collapse:collapse;
table-width:100%;
text-align:center;
}
</style>
</head>
<body bgcolor="white">

<h2>
<table style="width:100%">
<tr>
<th >Product id</th>
<th >Name</th>
<th style="width:20%" >Product Price</th>
<th >Quantity</th>
<th >Discount</th>
</tr>
<c:forEach var="p" items="${list}">
    <tr>
    <td style="width:25%" ><c:out value="${p.getProduct_id()}  "></c:out></td>
    <td style="width:25%" ><c:out value="${p.getProduct_name()}  "></c:out></td>
    <td style="width:20%"><c:out value="${p.getProduct_cost()} Rs "></c:out></td>
    <td style="width:10%"><c:out value="${p.getQuantity()} nos "></c:out></td>
    <td style="width:20%"><c:out value="${p.getDiscount()} % "></c:out></td>
    </tr>
  
</c:forEach> 
<tr><td > <c:out value="Total  "></c:out></td>
<td ><c:out value= "${ntotal} /- Rs Only"></c:out> </td>
</tr>
  <tr> <td ><c:out value="Total After Discount  "></c:out></td>

  <td ><c:out value= "${total} /- Rs Only"></c:out> </td>
  </tr> 
</table>
</h2>
<br>

<form action="paybill" >
<tr><td><input type="submit" name="btn"  value="Pay Out" style="height:30px;width:100px; font-size:20px"></td></tr> 
</form> 

</body>
</html>

