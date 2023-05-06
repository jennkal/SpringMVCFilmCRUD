package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private DatabaseAccessor FilmDAO;
	
	@RequestMapping(path = {"/", "home.do"})
	public String home(Model model) {
		return"WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = "GetFilmId.do",
			  		params = "id",
			  		method = RequestMethod.GET)
	public ModelAndView getFilmDetailsByFilmId(Integer filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = FilmDAO.findFilmById(filmId);
		mv.addObject("film" ,film);
		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}
}
