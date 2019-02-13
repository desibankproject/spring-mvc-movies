package com.movie.dao;

import java.util.List;

import com.movie.dao.entity.MovieEntity;

public interface IMovieDao {
	public String save(MovieEntity entity);
	public List<MovieEntity> findMovies();
	public String deleteMovieByTitle(String title);
	public List<MovieEntity> findMoviesByTitle(String title);
	public int  findMovieCount();
	public String deleteMovieByMid(int mid);
	public MovieEntity findMovieByMid(int mid);
	public String update(MovieEntity entity);
}
