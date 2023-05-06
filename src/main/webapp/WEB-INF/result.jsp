<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
</head>
<body>

	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li>${film.id}</li>
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.release_year}</li>
				<li>${film.language_id}</li>
				
				<li>${film.length}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film(s) found</p>
		</c:otherwise>
	</c:choose>



</body>
</html>