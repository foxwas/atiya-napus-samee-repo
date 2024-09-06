/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ARunner implements CommandLineRunner {
	
	// DONE: Inject the javatunes.default.search property
	@Value("${javatunes.default.search}")
	private String defaultSearchTerm;
	
	// DONE: Inject the javatunes.artistOfDay.name property
	@Value("${javatunes.artistOfDay.name}")
	private String artistOfDay = "Not Initialized";
	
	// DONE: Inject environment
	@Autowired
	private Environment env;
	
	// DONE: Inject the javatunes.url property
	@Value("${javatunes.url}")
	private String url;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("\n*** ARunner.run ***");
		checkProperties();
		System.out.println();
	}
	
	private void checkProperties() {
		// DONE: Retrieve the property javatunes.driverClassName from the Spring environment
		String driver = env.getProperty("javatunes.driverClassName", String.class);
		
		System.out.format("Default search value is: %s\n",defaultSearchTerm);
		System.out.format("Artist of Day is: %s\n",artistOfDay);
		System.out.format("Injected url: %s\n", url);
		System.out.format("Driver className from env: %s\n", driver );
	}

}
