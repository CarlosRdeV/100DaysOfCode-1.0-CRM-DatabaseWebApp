package com.carlosrdev.springdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carlosrdev.springdemo.entity.Movie;
import com.carlosrdev.springdemo.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	//need to inject the movie services
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/list")
	public String listMovies(Model theModel) {
		
		//get the movies from the service
		List<Movie> theMovies = movieService.getMovies();
		
		//add the movies to the model
		theModel.addAttribute("movies", theMovies); 
		
		return "list-movies";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create model attribute to bind form data
		Movie theMovie = new Movie();
		
		//inject the empty object into the model
		theModel.addAttribute("movie",theMovie);
		
		return "movie-form";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie theMovie) {
		//save the customer using our service
		movieService.saveMovie(theMovie);
		
		return "redirect:/movie/list";
	}
	
}
