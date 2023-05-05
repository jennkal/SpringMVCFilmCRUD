package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	 Film findFilmById(int filmId);

	 Actor findActorById(int actorId);

	 List<Actor> findActorsByFilmId(int filmId);
	 
	 List<Film> findFilmsByActorId(int actorId);

	Actor createActor(Actor actor);

	boolean saveActor(Actor actor);

	boolean deleteActor(Actor actor);

	Film createFilm(Film film);
	
	Film updateFilm(int filmId, Film film);
	
	boolean deleteFilm(Film film);

}
