<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<sec:authentication property="principal" var="user"/>
<br> 
<a href="../../logout">Logout</a>

<head>
<link rel="stylesheet" type="text/css" href="../css/gridtable.css"/>
<h1>Results for ${user.username}</h1>
</head>


<p>You scored: ${score} out of 10</p>
<p>Current Leaderboard</p>
<table class="gridtable">
	<tr>
	    <th>Position</th>
	    <th>Firstname</th> 
	    <th>Surname</th>
	    <th>Score</th>
	</tr>
<c:forEach items="${leaderboard}" var="ld" varStatus="row">
	<tr>
		<td>${row.index+1}. </td>
		<td>${ld.firstname}</td>
		<td>${ld.lastname}</td>
		<td>${ld.score}</td>
	</tr>
</c:forEach>
<br>
</table>
<br>

	<form method="get" action="../../accounts/all">
		<input type="submit" value="Back to Main Page">
	</form>

</html>	