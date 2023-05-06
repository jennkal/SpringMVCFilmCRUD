<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
  <h3>Update Film</h3>
<form action="updateFilm.do?filmId=${film.id }" method="GET">
	  <input type="hidden" name="id" value="${film.id}" >
	  <br>
      <label for="title">Title :</label>
      <input type="text" name="title" value="add the flim" >
      <br>
      <label for="description">Description :</label>
      <input type="text" name="description" >
      <br>
      <label for="release_year">Release Year:</label>
      <input type="number" name="year" >
      <br>
      <label for="language_id">Language :</label>
      <input type="number" name="langId" value="1">
      <br>
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
</body>
</html>