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
<title>Results</title>
</head>
<body>
	<c:choose>
		<c:when test="${film.id != 0}">
		
			<div class="filmTitle">
				<em><strong>${film.title}</strong></em>

			</div>

			<div class="result-container">
				<th colspan="2"><em>${film.description}.</em><br>
					<div class="subheader-container">
						rated <strong>${film.rating}</strong> | 
						${film.year} |
						${film.length} min. |
						id : ${film.id}
					</div>
					<table>
						<tr>
							<th>Cast</th>
							<th>Rental Details</th>
						</tr>
						<tr>
							<td>
								actors cannot be added at this time
								<c:forEach var="actor" items="${film.actors}">
									<li>${actor.firstName }${actor.lastName }</li>
								</c:forEach>
								</td>
							<td>
								<li>Rental Rate : $${film.rateRental}</li>
								<li>${film.rentalDur}maximumrental period</li>
								<li>Rental Rate : $${film.rateRental}</li>
								<li>${film.rentalDur} days max rental period</li>
								<li>Replacement cost : ${film.replaceCost}</li>
							</td>
						</tr>
					</table>
					<div class="button-container">
						<button class="delete-button"
							onclick="window.location.href = 'deleteFilm.do?filmId=${film.id }'; ">
							DELETE</button>
						<input value="HOWDY" type="hidden" name="title" />


						<button class="update-button"
							onclick="window.location.href = 'updateForm.do?filmId=${film.id }';">
							UPDATE</button>
						<input value="HOWDY" type="hidden" name="title" />
					</div>
		</c:when>
		<c:otherwise>
			<div class="filmnotfound">
				<p>FILM NOT FOUND</p>
			</div>
		</c:otherwise>
	</c:choose>



</body>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</html> 




<%-- <!DOCTYPE html>
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
</html> --%>