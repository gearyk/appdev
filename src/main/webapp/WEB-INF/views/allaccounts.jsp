<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1>All Accounts:</h1>
<c:out value="index"/>
<br/>
<c:forEach items="${allaccounts}" var="acc" varStatus="row">
${row.index}. ${acc.id} ${acc.firstname} ${acc.lastname} <br />
</c:forEach>
</html>
