<html>
<h1>Quiz App</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<br>
<br>
<br>
<h4>Existing Users - Log in and take the quiz</h4>
<form method="get" action= <%= request.getRequestURL() %>accounts/all >                       
<input type="submit" value="Login">
<br>
<br>
<br>
<h4>New Users - Sign Up here</h4>



		<form method="get" action= <%= request.getRequestURL() %>accounts/all >                       
		<input type="submit" value="Sign Up">
		</form>

</html>