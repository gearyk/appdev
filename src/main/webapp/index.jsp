<html>
<h1>Quiz App</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<head>
<link rel="stylesheet" type="text/css" href="../css/gridtable.css"/>
<h1>Existing Users - Log in and take the quiz</h1>
</head>
<body>
<form method="get" action= <%= request.getRequestURL() %>accounts/setquiz >                       
<input type="submit" value="Take Quiz">
</form>

<br>
<br>
<h1>New Users - Sign Up here</h1>
	<form method="get" action= <%= request.getRequestURL() %>accounts/all >                       
		<input type="submit" value="Sign Up">
	</form>
</body>
</html>