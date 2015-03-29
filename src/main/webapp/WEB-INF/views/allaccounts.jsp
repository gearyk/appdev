<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style>
table, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px;
}
th {
    width: 150px;
    border: 1px solid black;
}
</style>
<h1>All Accounts</h1>

<h4>Quiz</h4>
<form method="get" action="../accounts/setquiz">
<input type="submit" value="Take the Quiz">
</form>



<table>
<tr><th>Existing Accounts</ht></tr>
<tr>
<th>Index</th>
	    <th>Firstname</th> 
	    <th>Lastname</th>
	    </tr>
		<c:forEach items="${allaccounts}" var="acc" varStatus="row">
		<form method="post" action="${acc.id}">
			<tr>
				<td>${row.index}.</td>
				<td>${acc.firstname}</td> 
			    <td>${acc.lastname}</td>
				<td><input name="_method" type="hidden" value="delete"></td>
		  		<td><input type="submit" value="Delete Account"></td>
  			</tr>
  		</form>
 			<br/>
		</c:forEach>

</table>

<br/>

<h4>Create New Account</h4>
<form method="post" action="../accounts/">
First name:<br> <input name="firstname" type="text" value=""><br>
Second name:<br> <input name="lastname" type="text" value=""><br>
<br>
<input name="create" type="submit" value="Create Account">
</form>






</html>