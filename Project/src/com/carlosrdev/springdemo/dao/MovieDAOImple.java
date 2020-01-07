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

	@Override
	public void saveMovie(Movie theMovie) {
		
		//get the current session
		Session currenSession = sessionFactory.getCurrentSession();
		//save or update the movie
		currenSession.saveOrUpdate(theMovie);

	}

	@Override
	public Movie getMovie(int theId) {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//read from database using primary key
		Movie theMovie = currentSession.get(Movie.class, theId);

		return theMovie;
	}

}
