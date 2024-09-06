/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Declare this to be a Spring Boot application class
@SpringBootApplication
public class HelloBootWorld {

	public static void main(String[] args) {
      System.out.println("HelloBootWorld.main() called");
	  // Run the app as a Spring Boot app
      SpringApplication.run(HelloBootWorld.class, args);
    }

}
