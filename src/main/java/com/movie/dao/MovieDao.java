package com.movie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("MovieDao")
public class MovieDao implements IMovieDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String save(MovieEntity entity) {
		String query="insert into movie_tbl(title,director,year,story,poster,language) values(?,?,?,?,?,?)";
		Object data[]=new Object[]{entity.getTitle(),entity.getDirector(),entity.getYear(),entity.getStory(),entity.getPoster(),entity.getLanguage()};
		jdbcTemplate.update(query,data);
		return "success";
	}
	
	@Override
	public List<MovieEntity> findMovies() {
		String fecth="select * from  movie_tbl";
		List<MovieEntity> movies=jdbcTemplate.query(fecth,new BeanPropertyRowMapper(MovieEntity.class));
		return movies;
	}
	
	@Override
	public String deleteMovieByTitle(String title) {
		String fecth="delete  from  movie_tbl where title=?";
		Object data[]=new Object[]{title};
		int rows=jdbcTemplate.update(fecth,data);
		return rows!=0?"success":"failure";
	}
	
	@Override
	public List<MovieEntity> findMoviesByTitle(String title) {
		String fecth="select * from  movie_tbl where title=?";
		Object data[]=new Object[]{title};
		List<MovieEntity> movies=jdbcTemplate.query(fecth,data,new BeanPropertyRowMapper(MovieEntity.class));
		return movies;
	}
	
	@Override
	//Java5 - Autoboxing and unboxing
	public int findMovieCount() {
		String countQuery="select  count(*) from  movie_tbl";
		Integer count=jdbcTemplate.queryForObject(countQuery, Integer.class);
		return count;
	}
	
}
