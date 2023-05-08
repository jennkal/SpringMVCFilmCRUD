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
import com.skilldistillery.film.entities.Actor;
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
		
		ModelAndView mv = new ModelAndView(       );
		
		Film film = FilmDAO.findFilmById(filmId);
	
		mv.addObject("film", film);
		
		mv.setViewName("filmId");
		
		
		return mv;
	}
	
	@RequestMapping(path = "getFilmByKey.do", 
					params = "key", 
					method = RequestMethod.GET)
	public ModelAndView getFilmDetailsByKeyword(@RequestParam("key") String keyword) {
		ModelAndView mv = new ModelAndView();
		
		List<Film> filmList = FilmDAO.findFilmsByKeyword(keyword);
		
		mv.addObject("filmList", filmList);
		mv.setViewName("keywordResult");
		
		
		
		return mv;
	}

	// update below for add new film

	@RequestMapping(path = "addFilm.do", method = RequestMethod.GET)
	public ModelAndView createFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		if (FilmDAO.createFilm(film)) {
			redir.addFlashAttribute("film", film);	
		}
		
		mv.setViewName("redirect:filmCreated.do");
		return mv;
	}

	@RequestMapping(path = "filmCreated.do", // mapping to handle Redirect
					method = RequestMethod.GET)
	public ModelAndView created(Film film) {
		System.out.println("film object to display is: " + film);
		ModelAndView mv = new ModelAndView();
		//FilmDAO.updateFilm(film.getId(), film);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(path = "deleteFilm.do", 
					method = RequestMethod.GET  )
	public ModelAndView deleteFilm(@RequestParam int filmId, RedirectAttributes redir) {	
		ModelAndView mv = new ModelAndView();				
		if(FilmDAO.deleteFilm(filmId)) {
			mv.addObject("value", true);
		}
		else {
			mv.addObject("value", false);
		}
		mv.setViewName("delete");
		return mv;
	}
	
 @RequestMapping(path = "updateFilm.do",
		 		method = RequestMethod.GET )	
public ModelAndView updateFilm(Film updated) {
	 System.out.println("inside updatefilm.do controller");
	 ModelAndView mv = new ModelAndView();
	 System.out.println("film will be updated to:" + updated);
	 FilmDAO.updateFilm(updated.getId(), updated);	 
	 System.out.println("film has been updated to:" + updated);
	 mv.setViewName("updateResult");	 
	 return mv;
	 
 }
 
 @RequestMapping(path = "updateForm.do",
		 		method = RequestMethod.GET	)
public ModelAndView updateForm(@RequestParam ("filmId") int filmId, RedirectAttributes redir) {
	 	System.out.println("in updateform.do in controller");
		ModelAndView mv = new ModelAndView();
		
		Film film = FilmDAO.findFilmById(filmId);
		
		redir.addFlashAttribute("film", film);
	
		System.out.println(film);
	
//		mv.addObject("film", film);
		
		mv.setViewName("redirect:redirUpdate.do");
		
		return mv;
 }
 
 @RequestMapping(path = "redirUpdate.do",
		 		method = RequestMethod.GET	)
public ModelAndView redirUpdate( Film film, RedirectAttributes redir) {
	 System.out.println("in redirUpdate.do controller");
	 ModelAndView mv = new ModelAndView();
	 
	 redir.addFlashAttribute("film", film);
	 System.out.println("******"+film);
	 mv.setViewName("update");
	 
	 return mv;
 }
}

