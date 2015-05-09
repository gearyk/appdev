<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<sec:authentication property="principal" var="user"/>
<br> 
<a href="../logout">Logout</a>

<h1>Results for ${user.username} </h1>
You scored: ${score} out of 10
</html>	
<br>
<br>
<br>
<br>
<h4>Quiz</h4>
		<form method="get" action="../accounts/all">
		<input type="submit" value="Back to Main Page">
		</form>