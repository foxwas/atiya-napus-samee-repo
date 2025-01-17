/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.javatunes.config.SpringRepositoryConfig;


@Configuration
// TODO: Enable Spring Boot Auto-configuration
@EnableAutoConfiguration
@Import({SpringRepositoryConfig.class})
public class SpringConfig {	    	
}
