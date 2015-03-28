<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1>Take The Quiz</h1>

<c:forEach items="${answer}" var="ans" varStatus="row">
		${row.index}. 
		${ans.answer}
		
	</c:forEach>		
<html>		