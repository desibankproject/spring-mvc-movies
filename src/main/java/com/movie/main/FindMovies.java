package com.movie.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.movie.model.Movie;
import com.movie.service.MovieService;

public class FindMovies {

	public static void main(String[] args) {
		//We have to create spring container......................
		 ApplicationContext context=new ClassPathXmlApplicationContext("movie-service-dao.xml");
		 
		  MovieService movieService=(MovieService)context.getBean("MovieService");
		  List<Movie> movies=movieService.findMovies();
		  for(Movie item:movies){
			  System.out.println(item);
		  }
		 // movies.forEach(System.out::println);
	}

}
