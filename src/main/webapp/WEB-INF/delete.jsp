<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous" />

<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Delete Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${value==true}">
			
			<p>the Film has been deleted</p>
			
		</c:when>
		<c:otherwise>
		<div class="noSoup">
			You do not have the permissions to delete this film
		<iframe src="https://giphy.com/embed/dBZb8nAfLfOZ8B0CHA" width="480" height="360" frameBorder="0" class="giphy-embed" allowFullScreen>
		</iframe>
		</div>
		
		</c:otherwise>
	</c:choose>



</body>
</html>