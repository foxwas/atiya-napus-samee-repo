/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

// TODO: Declare this to be a Spring Boot application class
@SpringBootApplication
// TODO: Uncomment the below when you can
@Import({SpringServicesConfig.class})
public class HelloBootWorld {

	public static void main(String[] args) {
		System.out.println("HelloBootWorld.main() called");
		// TODO: Run the app as a Spring Boot app
		SpringApplication.run(HelloBootWorld.class, args);
	}

}
