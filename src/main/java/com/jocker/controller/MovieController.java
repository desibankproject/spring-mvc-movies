package com.jocker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.model.Movie;
import com.movie.service.IMovieService;

//@Controller is mandatory here
@Controller
public class MovieController {
	
	@Autowired   // ByType ->> @Qualifier ->>byName
	@Qualifier("MovieService")
	private IMovieService movieService;
	
	
	@GetMapping("/editMovie")
	public String editMovie(@RequestParam("mid") int mid,Model model) {
		//fetching movie data from the database using mid
		Movie  movie=movieService.findMovieByMid(mid);
		model.addAttribute("danger", movie);
		return "emovie"; ///movies
	}
	
	@GetMapping("/deleteMovie")
	public String deleteMovie(@RequestParam("mid") int mid,Model model) {
		//@RequestParam("mid") int mid
		//String mid= req.getParameter("mid");
		movieService.deleteMovieByMid(mid);
		//hey go to another action instead of jsp
		return "redirect:/movies"; ///movies
	}
	
	@GetMapping("/movies")
	public String showMovies(Model model){
		List<Movie> searchResults=movieService.findMovies();
		//req.setAttribute("magicResults", searchResults);
		model.addAttribute("magicResults", searchResults);
		return "movies"; ///WEB-INF/views/movie.jsp
	}
	
	
	@GetMapping("/movie")
	public String showMovie(){
		return "movie"; ///WEB-INF/views/movie.jsp
	}
	
	
	
	
	@PostMapping("/updateMovie")
	public String updateMovie(@ModelAttribute Movie movie,Model model){
	  	   String hold= movieService.update(movie);
			//model is used to carry data from controller to jsp
			//it is similar to req.setAttribute("student", student);
	  	  return "redirect:/movies"; ///movies
	}
	
	@PostMapping("/addMovie")
	public String registeStudent(@ModelAttribute Movie movie,Model model){
		//Taking data from jsp
	/*	String title=req.getParameter("title");
		String year=req.getParameter("year");
		String director=req.getParameter("director");
		String language=req.getParameter("language");
		String story=req.getParameter("story");
		String poster=req.getParameter("poster");
		 Movie movie=new Movie(title,year,director,language,story,poster);*/
		/* ApplicationContext context=new ClassPathXmlApplicationContext("movie-service-dao.xml");
		  IMovieService movieService=(IMovieService)context.getBean("MovieService");*/
		  String hold= movieService.save(movie);
		//model is used to carry data from controller to jsp
		//it is similar to req.setAttribute("student", student);
		  return "msuccess"; //no need to write extension
	}

}
