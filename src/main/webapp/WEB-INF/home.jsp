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
	crossorigin="anonymous"/>

<link rel="stylesheet" type="text/css" href="css/style.css" />

<title>Spring MVC Film Site</title>
</head>
<body>
	<div class="box">
		Welcome to our simple CRUD <em>(Create, Read, Update, Destroy)</em>
		web application that allows you to easily interact with a database.
		This webapp interface allows you to perform CRUD operations without
		any technical knowledge. Whether you need to add new records, retrieve
		data, update existing entries or delete records, our application makes
		it easy. Please click around and have fun, go ahead try to break
		something - if you do we'll get the chance to learn!
	</div>
	<div class="form-container"> 
	<h3><em>Search field options :</em></h3>
	
		<form action="GetFilmId.do" method="GET"> film id
			<input type="text" name="id" size="4" /> 
			<input type="submit" value="search" />
		</form>
		<form action="getFilmByKey.do" method="GET"> keyword
    		<input type="text" name="key" size="10"/> 
    		<input type="submit" value="search" />
  		</form>
	</div>
	<div class="footer">
		<a class="gitlink" href="https://github.com/jennkal/SpringMVCFilmCRUD"><em>check
				out our github for this project</em></a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>

<!-- 	<div class="button-container">
		<button class="my-button"
			onclick="window.location.href = 'filmById.html' ;">Find film
			by ID</button>
		<br>
		<button class="my-button"
			onclick="window.location.href = 'filmByKeyword.html';">Find
			film by Keyword</button>
		<br>
		<button class="my-button"
			onclick="window.location.href = 'newFilm.html';">Add new
			Film</button>
		<br>
	</div> -->