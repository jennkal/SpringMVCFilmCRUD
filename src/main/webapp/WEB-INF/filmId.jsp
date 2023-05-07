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
			<a href="deleteFilm.do?filmId=${film.id }">DELETE THIS FILM!!!</a>
			<input value="HOWDY" type="hidden" name="title"/>
			<br>
			<a href="updateForm.do?filmId=${film.id }">UPDATE THIS FILM!!!</a>
			
			<input value="HOWDY" type="hidden" name="title"/>
		</c:when>
		<c:otherwise>
			<p>No film(s) found</p>
		</c:otherwise>
	</c:choose>



</body>
</html>