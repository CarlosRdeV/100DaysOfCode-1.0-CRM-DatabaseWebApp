package com.carlosrdev.springdemo.dao;

import java.util.List;

import com.carlosrdev.springdemo.entity.Movie;

public interface MovieDAO {
	
	public List<Movie> getMovies();

	public void saveMovie(Movie theMovie);

	public Movie getMovie(int theId);

}
