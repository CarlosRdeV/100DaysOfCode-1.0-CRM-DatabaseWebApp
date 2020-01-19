package com.luv2com.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read json file and map/convert to Java POJO: 
			//data/sample-lite.json			
			Student theStudent = 
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first name and last name 
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("Last Name: " + theStudent.getLastName());
			System.out.println("Languages: " + theStudent.getLanguages());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
