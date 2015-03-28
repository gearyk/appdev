<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1>All Accounts</h1>
<table>
	<tr>
	    <th>Index</th>
	    <th>Firstname</th> 
	    <th>Lastname</th>
	    <th>ID</th>
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

<h4>Create Account</h4>
<form method="post" action="../accounts/">
First name:<br> <input name="firstname" type="text" value=""><br>
Second name:<br> <input name="lastname" type="text" value=""><br>
<input name="create" type="submit" value="Create Account">
</form>

</br>


</html>