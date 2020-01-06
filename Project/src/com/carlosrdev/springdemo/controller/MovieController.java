package com.carlosrdev.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carlosrdev.springdemo.dao.MovieDAO;
import com.carlosrdev.springdemo.entity.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {

	//need to inject the movie dao
	@Autowired
	private MovieDAO movieDAO;
	
	@RequestMapping("/list")
	public String listMovies(Model theModel) {
		
		//get the movies from the DAO
		List<Movie> theMovies = movieDAO.getMovies();
		
		//add the movies to the model
		theModel.addAttribute("movies", theModel);
		
		return "list-movies";
	}
	
}
