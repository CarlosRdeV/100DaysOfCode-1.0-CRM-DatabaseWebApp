package com.carlosrdev.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlosrdev.springdemo.dao.MovieDAO;
import com.carlosrdev.springdemo.entity.Movie;

@Service
public class MovieServiceImple implements MovieService {

	//need to inject movie dao
	@Autowired 
	private MovieDAO movieDAO;
	
	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public void saveMovie(Movie theMovie) {
		movieDAO.saveMovie(theMovie);
	}

}
