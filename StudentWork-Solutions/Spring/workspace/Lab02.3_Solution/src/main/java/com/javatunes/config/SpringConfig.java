/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// Declare as a Spring configuration class
// Add component scan for com.javatunes
// Import other config classes
@Configuration
@ComponentScan(basePackages = "com.javatunes")
@Import({SpringRepositoryConfig.class, SpringServicesConfig.class})
public class SpringConfig {}