package com.movie.soap.webservice.provider;

import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.movie.model.Movie;
import com.movie.service.MovieService;

/**
 * 
 * @author Nagendra
 *
 */
@WebService
public class MovieSoapWebServiceEndpoint {
	
	private static ApplicationContext applicationContext;
	static{
		//src/main/resources
		applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public String greet(String name){
		String message="Hello "+name+" , you are most welcome!!!!!!!!!!!!";
		return message;
	}

	public int add(int num1,int num2) {
		return num1+num2;
	}
	
	public List<Movie> showMovies(){
		MovieService  movieService=(MovieService)applicationContext.getBean("MovieService");
		List<Movie> searchResults=movieService.findMovies();
		return searchResults;
	}
}
