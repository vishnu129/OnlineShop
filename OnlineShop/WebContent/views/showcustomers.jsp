<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All</title>
<style type="text/css">
table, th, td {
border:2px solid black;
width:auto;
border-collapse:collapse;
text-align:center;
}
</style>
</head>
<body bgcolor="white">


<h3>
<table>
<tr>
<th>Customer id</th>
<th>Name</th>
<th>Wallet Balance</th>
</tr>
<c:forEach var="c" items="${list}">
    <tr>
    <td style="width:30%"><c:out value="${c.getCustomer_id()}  "></c:out></td>
    <td style="width:30%"><c:out value="${c.getCustomer_name()}  "></c:out></td>
    <td style="width:30%"><c:out value="${c.getWallet()} Rs "></c:out></td>
    </tr>
</c:forEach>  
</table>
</h3>


</body>
</html>

