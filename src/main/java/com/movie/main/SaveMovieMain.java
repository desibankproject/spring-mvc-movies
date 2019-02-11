package com.movie.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.movie.model.Movie;
import com.movie.service.IMovieService;

public class SaveMovieMain {

	public static void main(String[] args) {
		//We have to create spring container......................
		 ApplicationContext context=new ClassPathXmlApplicationContext("movie-service-dao.xml");
		 Scanner scanner=new Scanner(System.in);
		 System.out.println("Enter title");
		 String title=scanner.next();
		 System.out.println("Enter year");
		 String year=scanner.next();
		 System.out.println("Enter director");
		 String director=scanner.next();
		 System.out.println("Enter Language");
		  String language=scanner.next();
		  System.out.println("Enter Story");
		  String story=scanner.next();
		  System.out.println("Enter Poster");
		  String poster=scanner.next();
		  Movie movie=new Movie(title,year,director,language,story,poster);
		  IMovieService movieService=(IMovieService)context.getBean("MovieService");
		  String hold= movieService.save(movie);
		  System.out.println(hold);

	}

}
