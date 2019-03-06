package com.movie.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.ApplicationResponse;
import com.movie.service.IMovieService;

/**
 * 
 * @author Nagendra
 * 
 */
@RestController
@RequestMapping("/v3/movies")
public class MoviesRestController {
	
	@Autowired   // ByType ->> @Qualifier ->>byName
	@Qualifier("MovieService")
	private IMovieService movieService;
	
	//METHOD=DELETE
	//http://localhost:4554/movies-spring-jdbc/v3/movies/types/9882
	@DeleteMapping("/types/{kkmtid}")
	public ApplicationResponse deleteMovieByType(@PathVariable("kkmtid") int mtid,Model model) {
		//This I forget to call...............
		movieService.deleteMovieTypeByMtid(mtid);
		ApplicationResponse applicationResponse=new ApplicationResponse();
		applicationResponse.setStatus("success");
		applicationResponse.setMessage("Hey! your resource  is deleted successfully.............. ");
		return applicationResponse;
	}
	
	///METHOD= POST
	///http://localhost:4554/movies-spring-jdbc/v3/movies/types
	@PostMapping("/types")
	public ApplicationResponse addMovieType(@RequestBody MovieTypeVO movieType,Model model) {
		//This I forget to call...............
		movieService.saveMovieType(movieType.getMid(), movieType.getName());
		ApplicationResponse applicationResponse=new ApplicationResponse();
		applicationResponse.setStatus("success");
		applicationResponse.setMessage("Hey! your resource  is deleted successfully.............. ");
		return applicationResponse;
	}
	
	
}
