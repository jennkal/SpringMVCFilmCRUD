<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${value==true}">
			
			<p>the Film has been deleted</p>
			
		</c:when>
		<c:otherwise>
			<p>Unable to delete film. No soup for you.</p>
		</c:otherwise>
	</c:choose>



</body>
</html>