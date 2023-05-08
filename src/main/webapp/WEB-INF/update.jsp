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
<title>Update</title>
</head>
<body>
  <div class="filmTitle">
  Update Film
  </div>
  
  <div class="update-container"> 
	<form action="updateFilm.do?filmId=${film.id }" method="GET">
	  <input type="hidden" name="id" value="${film.id}" >

      <label for="title">Title :</label>
      <input type="text" name="title">
<br>
      <label for="description">Description :</label>
      <input type="text" name="description" >
<br>
      <label for="release_year">Release Year:</label>
      <input type="number" name="year" >
<br>
<!--       <label for="language_id">Language :</label>
      <input type="number" name="langId" value="1">
 -->
      <label for="rental_duration">Rental duration :</label>
      <input type="number" name="rentalDur">
<br>
      <label for="rental_rate">Rental Rate :</label>
      <input type="number" name="rateRental" >
<br>
      <label for="replacement_cost">Replacement cost :</label>
      <input type="number" name="replaceCost" >
<br>
      <label for="rating">Rating :</label>
      <input type="text" name="rating" >
<br>
      <input type="submit" value="Update Film">

    </form>
    </div>
</body>
</html>