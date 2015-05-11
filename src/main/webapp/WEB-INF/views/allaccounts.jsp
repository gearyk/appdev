<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<sec:authentication property="principal" var="user"/>
<br> 
<a href="../logout">Logout</a>
<head>
<link rel="stylesheet" type="text/css" href="css/gridtable.css"/>
</head>

<h1>All Accounts</h1>
<h4>Quiz</h4>
<form method="get" action="../accounts/setquiz">
<input type="submit" value="Take the Quiz">
</form>
<br>
<br>
<table class="gridtable">
<tr><th colspan="4">Existing Accounts</th></tr>
	<tr width="40%"><th>Index</th><th>Firstname</th> <th>Lastname</th><th>Remove Account</th>
	</tr><c:forEach items="${allaccounts}" var="acc" varStatus="row">
		<form method="post" action="${acc.id}">
			<tr>
				<td>${row.index}.</td>
				<td>${acc.firstname}</td> 
			    <td>${acc.lastname}</td>
				<input name="_method" type="hidden" value="delete">
		  		<td><input type="submit" value="Delete"></td>
  	</tr>
  		</form>
 			
			</c:forEach>
</table>

<br/>

<h4>Create New Account</h4>
<form method="post" action="../accounts/">
First name:<br> <input name="firstname" type="text" value=""><br>
Second name:<br> <input name="lastname" type="text" value=""><br>
username:<br> <input name="username" type="text" value=""><br>
password:<br> <input type="password" name=pwd type="text" value=""><br>
<br>
<input name="create" type="submit" value="Create Account">
</form>






</html>