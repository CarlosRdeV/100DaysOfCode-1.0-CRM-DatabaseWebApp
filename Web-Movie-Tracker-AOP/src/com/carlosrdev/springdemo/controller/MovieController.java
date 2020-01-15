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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int theId, 
						Model theModel) {
		
		//get the movie from our service
		Movie theMovie = movieService.getMovie(theId);
		
		//set movie as a model attribute to pre-polute the form
		theModel.addAttribute("movie",theMovie);
		
		//send over to our form	
		return "movie-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("movieId") int theId) {
		
		//delete the customer
		movieService.deleteMovie(theId);
		
		return "redirect:/movie/list";
	}
	
}
