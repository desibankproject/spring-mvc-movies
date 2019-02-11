package com.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movie.dao.IMovieDao;
import com.movie.dao.MovieEntity;
import com.movie.model.Movie;

@Service("MovieService")
public class MovieService implements IMovieService {

	@Autowired
	@Qualifier("MovieDao")
	private IMovieDao movieDao;

	@Override
	public String save(Movie movie) {
		MovieEntity entity=new MovieEntity();
		BeanUtils.copyProperties( movie, entity);
		String result=movieDao.save(entity);
		return result;
	}

	@Override
	public List<Movie> findMovies() {
		List<MovieEntity> entities=movieDao.findMovies();
		List<Movie>  movies=new ArrayList<Movie>();
		for(MovieEntity entity:entities){
			Movie movie=new Movie();
			BeanUtils.copyProperties( entity, movie);
			movies.add(movie);
		}
		return movies;
	}

	@Override
	public String deleteMovieByTitle(String title) {
		return movieDao.deleteMovieByTitle(title);
	}

	@Override
	public List<Movie> findMoviesByTitle(String title) {
		List<MovieEntity> entities=movieDao.findMoviesByTitle(title);
		List<Movie>  movies=new ArrayList<Movie>();
		for(MovieEntity entity:entities){
			Movie movie=new Movie();
			BeanUtils.copyProperties( entity, movie);
			movies.add(movie);
		}
		return movies;
	}


	@Override
	// Java5 - Autoboxing and unboxing
	public int findMovieCount() {
		return movieDao.findMovieCount();
	}

}
