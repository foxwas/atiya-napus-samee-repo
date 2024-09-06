/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
// TODO: Make the code in the class run last
@Order(Ordered.LOWEST_PRECEDENCE)
// TODO: Make this class a runner
public class ARunner implements CommandLineRunner{
	
	// TODO: Add @Override when you can.
	public void run(String... arg0) throws Exception {
		System.out.println("*** ARunner.run ***");
		System.out.println("Arguments are");
		for (String cur : arg0) {
			System.out.println(cur);
		}
		System.out.println();
	}

}
