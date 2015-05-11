<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<sec:authentication property="principal" var="user"/>
<br> 
<a href="../../logout">Logout</a>
<style>
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
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
* {
 margin: 0;
 padding: 0;
}
	
}
</style>

<h1>Results for ${user.username} </h1>
You scored: ${score} out of 10
</html>	
<br>
<br>
Current Leaderboard
<br>
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
<h4>Quiz</h4>
		<form method="get" action="../../accounts/all">
		<input type="submit" value="Back to Main Page">
		</form>
