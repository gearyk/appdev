<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html" %>
<%@page import="java.util.*" %>


<html>
<sec:authentication property="principal" var="user"/>
<br> 
<a href="../logout">Logout</a>
<head>
<link rel="stylesheet" type="text/css" href="css/gridtable.css"/>
</head>
<body>




<table id=table class="gridtable" >
		<th colspan="6">Take The Quiz</th></tr>
			<tr>
			    <th>Index</th>
			    <th>Question</th> 
			    <th>Answer</th>
			    <th>Answer</th>
			    <th>Answer</th>
			    <th>Answer</th>
	    	</tr>
<c:forEach items="${questions}" var="quest" varStatus="row">

<c:set var="rand" value="<%= (int) (Math.random() * 10) %>" />

			<tr id="${rand}" >
				<td>${row.index+1}. </td>
				<td>${quest.question}</td>
				<c:if test="condition"></c:if>
				<c:choose>
					<c:when test= "${(rand <= 2)}">
					
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.answer}/${quest.answer}">
							<input  type="submit" value="${quest.answer}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong1}/${quest.answer}">
							<input  type="submit" value="${quest.wrong1}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong2}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong3}. "></form>
						</td>
					</c:when>
					<c:when test= "${(rand > 2) && (rand< 6 )}">
					
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong1}/${quest.answer}">
							<input  type="submit" value="${quest.wrong1}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong2}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong3}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.answer}/${quest.answer}">
							<input  type="submit" value="${quest.answer}. "></form>
						</td>
					</c:when>
					<c:when test= "${ (rand > 6) && (rand < 8)}">
					
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong1}/${quest.answer}">
							<input  type="submit" value="${quest.wrong1}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.answer}/${quest.answer}">
							<input  type="submit" value="${quest.answer}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong2}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong3}. "></form>
						</td>
				</c:when>
				<c:otherwise>
				
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong1}/${quest.answer}">
							<input  type="submit" value="${quest.wrong1}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong2}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.answer}/${quest.answer}">
							<input  type="submit" value="${quest.answer}. "></form>
						</td>
						<td>
							<form method="get" action="../accounts/quiz/${quest.id}/${quest.wrong2}/${quest.answer}">
							<input  type="submit" value="${quest.wrong3}. "></form>
						</td>
				</c:otherwise>
				</c:choose>
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

</html>

