/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class Runner1 implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Runner1.run");
		for (String cur : arg0) {
			System.out.println(cur);
		}
	}

}
