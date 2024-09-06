package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.javatunes.config.SpringConfig;

@SpringBootApplication
@Import(SpringConfig.class)
// DONE: Uncomment the extends for non-embedded deployment
public class BootWebDemo extends SpringBootServletInitializer {

	// DONE: Uncomment this method for non-embedded deployment.
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    	System.out.println("BootWebDemo.configure()");
//        return application.sources(BootWebDemo.class);
//    }
	
    public static void main(String[] args) {
    	System.out.println("BootWebDemo.main() called");
        SpringApplication.run(BootWebDemo.class, args);
    }   
}
