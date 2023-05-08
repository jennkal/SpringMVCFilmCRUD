<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous"/>

<link rel="stylesheet" type="text/css" href="css/style.css" />

<title>Result</title>
</head>
<body>

	<c:choose>
		<c:when test="${film.id != 0}">
			<ul>

				<li>Film ID : ${film.id}</li>
				<li>Title : ${film.title}</li>
				<li>Description : ${film.description}</li>
				<li>Release Year : ${film.year}</li>
				<li>Language : ${film.langId}</li>
				<li>Rental Duration : ${film.rentalDur}</li>
				<li>Film length :${film.length}</li>
				<li>Replacement cost: ${film.replaceCost}</li>
				<li>Rental Rate :${film.rateRental}</li>
				<li>Rating :${film.rating}</li>
				<li>Special features :${film.specFeat}</li>

			</ul>
			<!--  	<a href="deleteFilm.do?filmId=${film.id }">DELETE THIS FILM!!!</a>
			<input value="HOWDY" type="hidden" name="title"/>
			<br>
			<a href="updateForm.do?filmId=${film.id }">UPDATE THIS FILM!!!</a>
			<input value="HOWDY" type="hidden" name="title"/> -->
		</c:when>
		<c:otherwise>
			<p>Unable to add film. Please check inputs and try again. Don't
				make me get my pitchfork</p>
		</c:otherwise>
	</c:choose>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>