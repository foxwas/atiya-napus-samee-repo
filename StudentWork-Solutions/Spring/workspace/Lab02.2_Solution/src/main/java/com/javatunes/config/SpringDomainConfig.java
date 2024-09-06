/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.domain.DomainSettings;

// OPTIONAL TODO: Declare as a Spring configuration class
public class SpringDomainConfig {

	// TODO: Declare as a bean definition

	public DomainSettings domainSettings () {
		int max = Math.max(1, (int) (Math.random()*10)); // Generate a random number 
		// TODO: Return the DomainSettings object configured with a random number
		// The above code generating the random number is executed when the Bean is created
		// When that happens is not exactly under our control - but the code is!
		return null;
	}
	
}