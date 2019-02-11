package com.movie.dao;

import java.util.List;

public interface IMovieDao {
	public String save(MovieEntity entity);
	public List<MovieEntity> findMovies();
	public String deleteMovieByTitle(String title);
	public List<MovieEntity> findMoviesByTitle(String title);
	public int  findMovieCount();
}
