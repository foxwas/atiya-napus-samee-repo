/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes;

import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.services.MyRunner;

public class HelloNOBootWorld {

    public static void main(String[] args) {
    	System.out.println("HelloBootWorld.main() called");
    	
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

    	try {
    			Map<String,MyRunner> beans = ctx.getBeansOfType(MyRunner.class);
    			Collection<MyRunner> runners = beans.values();
    			for (MyRunner cur : runners) {
    				cur.run(args);
    			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        ctx.close();
    }
   
}
