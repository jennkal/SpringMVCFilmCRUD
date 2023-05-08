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
		<c:when test="${! empty film}">
			<div class="filmTitle">
				<em><strong>${film.title}</strong></em>

			</div>

			<div class="result-container">
				<th colspan="2"><em>${film.description}.</em><br>
					<div class="subheader-container">
						rated <strong>${film.rating}</strong> | ${film.year} |
						${film.length} min. | ${film.language } |
						<c:forEach var="category" items="${film.categories}"> ${category }
				</c:forEach>
						| id : ${film.id}
					</div>
					<table>
						<tr>
							<th>Cast</th>
							<th>Rental Details</th>
						</tr>
						<tr>
							<td><c:forEach var="actor" items="${film.actors}">
									<li>${actor.firstName }${actor.lastName }</li>
								</c:forEach></td>
							<td>
								<li>Rental Rate : $${film.rateRental}</li>
								<li>${film.rentalDur}maximumrental period</li>
								<li>Replacement cost : ${film.replaceCost}</li>
								<li>Special features : ${film.specFeat}</li>
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
</html>