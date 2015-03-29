<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1>Take The Quiz</h1>

<table>
	<tr>
	    <th>Index</th>
	    <th>Question</th> 
	    <th>ID</th>
	    <th>Answer</th>
	    <th>Answer</th>
	    <th>Answer</th>
	    <th>Answer</th>
	    
  	</tr>
<c:forEach items="${questions}" var="quest" varStatus="row">
		<tr>
			<td>${row.index}. </td>
			<td>${quest.question}</td>
			<td>${quest.id}</td>
			
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
  		</form>
 			<br/>
		</c:forEach>
		</table>
		
	<h4>Quiz</h4>
		<form method="get" action="../accounts/all">
		<input type="submit" value="Back to Main Page">
		</form>

	<h4>Get your Score</h4>
		<form method="get" action="../accounts/score">
		<input type="submit" value="Get Score">
		</form>
	
</html>

