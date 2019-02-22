package com.jocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.service.IMovieService;

@RestController
public class JSONDataController {

	@Autowired   // ByType ->> @Qualifier ->>byName
	@Qualifier("MovieService")
	private IMovieService movieService;
	
	@GetMapping("/movies/json")
	public List<Movie> showMoviesAsJson(){
		List<Movie> searchResults=movieService.findMovies();
		return searchResults;
	}
}
