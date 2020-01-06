package com.carlosrdev.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carlosrdev.springdemo.entity.Movie;

@Repository
public class MovieDAOImple implements MovieDAO {

	//need to inject the session factory
	@Autowired
	SessionFactory sessionFactory;
		
	@Override
	@Transactional
	public List<Movie> getMovies() {
		// get the current session
		Session currentSesson = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Movie> theQuery = 
				currentSesson.createQuery("from Movie", Movie.class);
		
		// execute query and get result list
		List<Movie> movies = theQuery.getResultList();
		
		//return the results
		return movies;
	}

}
