package com.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.movie.dao.entity.MovieEntity;

@Repository("MovieHibernateDao")
@Transactional(value="hibernateTxManager")
public class MovieHibernateDao  implements IMovieDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieEntity> findMoviesByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMovieCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deleteMovieByMid(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieEntity findMovieByMid(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(MovieEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findImageByMid(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
