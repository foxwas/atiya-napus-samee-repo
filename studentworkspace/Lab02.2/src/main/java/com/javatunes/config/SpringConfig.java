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

// TODO: Declare as a Spring configuration class
@Configuration
// TODO: Add component scan for com.javatunes
@ComponentScan("com.javatunes")
// TODO: Import other config classes (including optional SpringDomain)
@Import({SpringServicesConfig.class, SpringRepositoryConfig.class})
public class SpringConfig {}