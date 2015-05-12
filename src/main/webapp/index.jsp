<html>
<h1>Quiz App</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<head>
<h2>Existing Users - Log in and take the quiz</h1>
</head>
<body>
<form method="get" action= <%= request.getRequestURL() %>accounts/setquiz >                       
<input type="submit" value="Take Quiz">
</form>

<br>
<br>
<h2>New Users - Sign Up here</h1>
	<form method="get" action= <%= request.getRequestURL() %>accounts/all >                       
		<input type="submit" value="Sign Up">
	</form>
</body>



<style type="text/css">
head{
	background-color: #b0c4de;
}
body{
	background-color: #f0f0f0;
}
h1 {
    color:grey;
    font-family:Calibri;
    font-size:200%;
}
h2 {
    color:grey;
    font-family:Calibri;
    font-size:150%;
}
p{
    color:grey;
    font-family:Calibri;
    font-size:120%;
}
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</html>