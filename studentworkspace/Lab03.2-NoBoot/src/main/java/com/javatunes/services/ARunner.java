/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ARunner implements MyRunner {
	
	@Value("${javatunes.database.name}")
	private String dbName;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("*** ARunner.run ***");
		System.out.format("Database name is: %s\n",dbName);
		System.out.println("Arguments are");
		for (String cur : arg0) {
			System.out.println(cur);
		}
		System.out.println();
	}

}
