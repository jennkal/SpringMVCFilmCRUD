package com.skilldistillery.film.data; 

import java.util.List;



import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Copies;

public interface DatabaseAccessor {
	 Film findFilmById(int filmId);

	 Actor findActorById(int actorId);

	 List<Actor> findActorsByFilmId(int filmId);
	 
	 List<Film> findFilmsByActorId(int actorId);

	Actor createActor(Actor actor);

	boolean saveActor(Actor actor);

	boolean deleteActor(Actor actor);

	boolean createFilm(Film film);
		
	List<Copies> findCopiesById(int filmId);

	List<Film> findFilmsByKeyword(String keyword);

	boolean deleteFilm(int filmId);

	boolean updateFilm(int filmId, Film updated);
	
	List<String> findCategoryByFilmId(int filmId);

}
