package com.movie.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.movie.dao.entity.MovieEntity;


@Repository("MovieDao")
public class MovieDao implements IMovieDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public String update(MovieEntity entity) {
		String query="update  movie_tbl set title=?,director=?,year=?,story=?,poster=?,language=? where mid=?";
		Object data[]=new Object[]{entity.getTitle(),entity.getDirector(),entity.getYear(),entity.getStory(),entity.getPoster(),entity.getLanguage(),entity.getMid()};
		jdbcTemplate.update(query,data);
		return "success";
	}
	
	@Override
	public String save(MovieEntity entity) {
       //Below lines are converting photo byte[] array into SqlLobValue 
		LobHandler lobHandler=new DefaultLobHandler();
        SqlLobValue sqlLobValue=new SqlLobValue(entity.getPhoto(),lobHandler);
		String query="insert into movie_tbl(title,director,year,story,poster,language,photo) values(?,?,?,?,?,?,?)";
        int[] dataType=new int[] { Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.BLOB };
		Object data[]=new Object[]{entity.getTitle(),entity.getDirector(),entity.getYear(),entity.getStory(),entity.getPoster(),entity.getLanguage(),sqlLobValue};
		jdbcTemplate.update(query,data,dataType);
		return "success";
	}
	
	@Override
	public List<MovieEntity> findMovies() {
		String fecth="select * from  movie_tbl";
		List<MovieEntity> movies=jdbcTemplate.query(fecth,new BeanPropertyRowMapper(MovieEntity.class));
		return movies;
	}
	
	@Override
	public String deleteMovieByMid(int mid) {
		String fecth="delete  from  movie_tbl where mid=?";
		Object data[]=new Object[]{mid};
		int rows=jdbcTemplate.update(fecth,data);
		return rows!=0?"success":"failure";
	}
	
	@Override
	public byte[] findImageByMid(int mid) {
		String fecth="select photo  from  movie_tbl where mid=?";
		Object data[]=new Object[]{mid};
		byte[] photo=jdbcTemplate.queryForObject(fecth,data,byte[].class);
		return photo;
	}
	
	@Override
	public MovieEntity findMovieByMid(int mid) {
		String fecth="select * from  movie_tbl where mid="+mid;
		MovieEntity movieEntity=jdbcTemplate.queryForObject(fecth,new BeanPropertyRowMapper<MovieEntity>(MovieEntity.class));
		return movieEntity;
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
