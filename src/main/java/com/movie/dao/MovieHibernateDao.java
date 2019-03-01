package com.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.movie.dao.entity.MovieEntity;
import com.movie.dao.entity.MovieType;

@Repository("MovieHibernateDao")
@Transactional(value="hibernateTxManager")
public class MovieHibernateDao  implements IMovieDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String saveMovieType(MovieType movieType) {
		getSession().save(movieType);
		return "success";
	}

	@Override
	public String save(MovieEntity entity) {
		boolean agaga=TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println(agaga);
		getSession().save(entity);
		return "success";
	}

	@Override
	public List<MovieEntity> findMovies() {
		Query<MovieEntity> query=getSession().createQuery("from  MovieEntity"); //HQL
		 List<MovieEntity> movieEntities=query.list();
		return movieEntities;
	}

	@Override
	public String deleteMovieByTitle(String title) {
		Query<MovieEntity> query=getSession().createQuery("delete from  MovieEntity as t where t.title=?"); //HQL
		query.setParameter(1, title);
		query.executeUpdate();
		return "success";
	}

	@Override
	public List<MovieEntity> findMoviesByTitle(String title) {
		Query<MovieEntity> query=getSession().createQuery("from  MovieEntity as t where t.title=?"); //HQL
		query.setParameter(1, title);
		 List<MovieEntity> movieEntities=query.list();
		return movieEntities;
	}

	@Override
	public int findMovieCount() {
		Query<MovieEntity> query=getSession().createQuery(" SELECT COUNT(*) FROM  MovieEntity"); //HQL
        Object empCount = query.getSingleResult();
		return (Integer)empCount;
	}

	@Override
	public String deleteMovieByMid(int mid) {
		MovieEntity entity=getSession().find(MovieEntity.class, mid);
		getSession().delete(entity);
		return "success";
	}

	@Override
	public MovieEntity findMovieByMid(int mid) {
		MovieEntity entity=getSession().get(MovieEntity.class, mid);
		return entity;
	}

	@Override
	public String update(MovieEntity entity) {
		getSession().update(entity);
		return "success";
	}

	@Override
	public byte[] findImageByMid(int mid) {
		MovieEntity entity=getSession().get(MovieEntity.class, mid);
		return entity.getPhoto();
	}

}
