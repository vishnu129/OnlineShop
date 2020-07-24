<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer LogIn</title>
<style type="text/css">
table, th, td {
border:px solid black;
width:100%;
text-align:center;
}

.container{
padding:16px;
border:thick;
border:#C06;
}
button {
  background-color:#161415;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  text-align:center;
  vertical-align:middle;
  width: 20%;
  text-align:center;
 
}
div.container{

border-color:black;

}
div {
  height: 300px;
  width: 25%;
  padding-top:200p<h5></h5>;
  background-color:#C8C8C8;
  margin:auto;
  margin-top:10%;
  border: 10px;
  border-color:black;
}

</style>
</head>
<body bgcolor="white">
<div class="container", align="center" style="vertical-align:middle">
<h1 align="center"><font color="black">Customer Login</font></h1>
<br>
<form action="clogin" method="post"  >
<label for="id"><b><font color="black" size="4px"><b>CustomerId</b></label>
<input type="text" name="id" placeholder="Enter CustomerId" required><br><br>
<label for="password"><b>Password</b></label>
<input type="password" name="password" placeholder="Enter Password" required><br>
<button type="submit" style="text-align:center"><b>Login</b></button></font>
</form>
</div>
</body>
</html>