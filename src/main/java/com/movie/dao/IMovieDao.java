package com.movie.dao;

import java.util.List;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.movie.dao.entity.MovieEntity;
import com.movie.dao.entity.MovieType;

public interface IMovieDao {
	public String save(MovieEntity entity);
	public List<MovieEntity> findMovies();
	public String deleteMovieByTitle(String title);
	public List<MovieEntity> findMoviesByTitle(String title);
	public int  findMovieCount();
	public String deleteMovieByMid(int mid);
	public MovieEntity findMovieByMid(int mid);
	public String update(MovieEntity entity);
	byte[] findImageByMid(int mid);
	default String saveMovieType(MovieType movieType){
		return null;
	}
}
