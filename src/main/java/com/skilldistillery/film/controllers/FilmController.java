package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private DatabaseAccessor FilmDAO;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(path = "GetFilmId.do", 
					params = "id", 
					method = RequestMethod.GET)
	public ModelAndView getFilmDetailsByFilmId(@RequestParam("id") Integer filmId) {
		
		ModelAndView mv = new ModelAndView();
		Film film = FilmDAO.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("result");
		
		
		return mv;
	}
	@RequestMapping(path = "getFilmByKey.do", 
					params = "key", 
					method = RequestMethod.GET)
	public ModelAndView getFilmDetailsByKeyword(@RequestParam("key") String keyword) {
		
		
		ModelAndView mv = new ModelAndView();
		List<Film> film = FilmDAO.findFilmsByKeyword(keyword);
		mv.addObject("film", film);
		mv.setViewName("result");
		
		System.out.println("in controller" + film);
		
		return mv;
	}

	// update below for add new film

	@RequestMapping(path = "addFilm.do", method = RequestMethod.GET)
	public ModelAndView createFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		FilmDAO.createFilm(film);
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmCreated.do");
		return mv;
	}

	@RequestMapping(path = "filmCreated.do", // mapping to handle Redirect
					method = RequestMethod.GET)
	public ModelAndView created(Film film) {
		ModelAndView mv = new ModelAndView();
		FilmDAO.updateFilm(film);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(path = "deleteFilm.do", 
					method = RequestMethod.GET  )
	
	public ModelAndView deleteFilm(Film film) {
		
		ModelAndView mv = new ModelAndView();
		
		FilmDAO.deleteFilm(film);
		
		mv.setViewName("delete");
		
		return mv;
	}
	
	
}
