package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load the student data ... only once!
	
	@PostConstruct
	public void loadDate() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Fernando", "Melendez"));
		theStudents.add(new Student("Karen", "Reyes"));
		theStudents.add(new Student("Marry", "Martinez"));
		
	}
	
	//define end point for "/students" - return list of students 
	@GetMapping("/students")
	public List<Student> getStudents(){
				
		return theStudents;
	}
	
	// define end point for "/students/{studentId}" - retunr student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		return theStudents.get(studentId);
	}
}
