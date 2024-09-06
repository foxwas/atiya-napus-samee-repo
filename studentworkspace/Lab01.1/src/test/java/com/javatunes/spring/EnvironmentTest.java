/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.spring; 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnvironmentTest {


	/*
	 * Normally we wouldn't test to see if something we just created with "new" was null.
	 * We're really just testing to make sure our environment is set up correctly.
	 */
	@Test 
	public void testContextNotNullPositive() {
	//	Standalone XML application context, taking the context definition filesfrom the class path, interpreting plain paths as class path resource namesthat include the package path (e.g. "mypackage/myresource.txt"). Useful fortest harnesses as well as for application contexts embedded within JARs. 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
	
		assertNotNull(ctx, "spring container should not be null");
		System.out.println("Spring was bootstrapped for environment " + ctx.getEnvironment());
		ctx.close();
	}
}
