<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<sec:authentication property="principal" var="user"/>
<br> 
<a href="../logout">Logout</a>
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
<body>



<table class="gridtable">
<tr><th colspan="6">Take The Quiz</th></tr>
	<tr>
	    <th>Index</th>
	    <th>Question</th> 
	    <th>Answer</th>
	    <th>Answer</th>
	    <th>Answer</th>
	    <th>Answer</th>
	    
  	</tr>
<c:forEach items="${questions}" var="quest" varStatus="row">
		<tr>
			<td>${row.index+1}. </td>
			<td>${quest.question}</td>
			
			<td>
			<form method="get" action="../accounts/quiz/${quest.id}/${quest.answer}/${quest.answer}">
			<input type="submit" value="${quest.answer}. "></form>
			</td>
			<td>
			<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong1}/${quest.answer}">
			<input type="submit" value="${quest.wrong1}. "></form>
			</td>
			<td>
			<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
			<input type="submit" value="${quest.wrong2}. "></form>
			</td>
			<td>
			<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
			<input type="submit" value="${quest.wrong3}. "></form>
			</td>		
		</tr>
		</c:forEach>
		
		</table>
		
		
<br>		
<table>
	<tr>
		<form method="get" action="../accounts/all">
		<input type="submit" value="Back to Main Page">
		</form>
	</tr>
	<tr>
		<form method="get" action="../accounts/quiz/${user.username}">
		<input type="submit" value="Get Score">
		</form>
	</tr>
</table>
</body>	
</html>

