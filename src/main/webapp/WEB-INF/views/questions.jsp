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
			<td><input type="submit" value="${quest.answer}. "></td>
			<td><input type="submit" value="${quest.wrong1}. "></td>
			<td><input type="submit" value="${quest.wrong2}. "></td>
			<td><input type="submit" value="${quest.wrong3}. "></td>
		
			
			<td><input name="_method" type="hidden" value="PUT"></td>
			
			
			
				
		</tr>
  		</form>
 			<br/>
		</c:forEach>
		</table>
		
	
</html>

