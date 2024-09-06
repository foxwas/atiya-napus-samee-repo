package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatunes.config.SpringConfig;

@SpringBootApplication
@Import(SpringConfig.class)
public class BootRESTDemo {
	
    public static void main(String[] args) {
    	System.out.println("BootRESTDemo.main() called");
        SpringApplication.run(BootRESTDemo.class, args);
    }   
}
