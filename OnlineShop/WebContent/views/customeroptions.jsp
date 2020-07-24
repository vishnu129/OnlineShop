<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Options</title>
<style type="text/css">
table, th, td {
border:0px solid black;
width:100%;
border-collapse:collapse;
text-align:center;
}
</style>
<style>
.button {
  border-width: 2px;
  width:300px;
  border-color:green;
  color: white;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 19px;
  margin: 4px 2px;
  cursor: pointer;
  background-color: black;
}

</style>
</head>
<body bgcolor="lightblue">


<table>



<tr><td><br></td></tr>
<tr><td><h1>Customer Options</h1></td></tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="showallprod" >Show All Products </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="addtocart.jsp" >Add Product to Cart </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="showcart" >Show Cart </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="deletecart.jsp" >Remove From Cart </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="showbalance" >Show Wallet </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="addbalance.jsp" >Add Balance to Wallet </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="changepassword.jsp" >Change Password </button>
</form> </td></tr>
<tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="checkout" >Check Out </button>
</form> </td></tr>
<tr>


<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="home.jsp" >Logout </button>
</form> </td></tr>
<tr>


</table>


</body>
</html>