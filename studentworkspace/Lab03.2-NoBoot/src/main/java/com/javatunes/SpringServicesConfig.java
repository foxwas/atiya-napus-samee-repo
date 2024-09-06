/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.services.AnotherRunner;
import com.javatunes.services.MessageService;
import com.javatunes.services.MessageServiceImpl;
import com.javatunes.services.MyRunner;

@Configuration
public class SpringServicesConfig {
	
	// Define a message service bean
	@Bean
	public MessageService messageService() {
		return new MessageServiceImpl();
	}

	@Bean
	public MyRunner anotherRunner() {
		AnotherRunner runner = new AnotherRunner();
		runner.setTheMessageService(messageService());
		return runner;
	}	
}