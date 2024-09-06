package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatunes.config.SpringConfig;

@SpringBootApplication
@Import(SpringConfig.class)
public class BootRestApp {
	
    public static void main(String[] args) {
    	System.out.println("BootRestApp.main() called");
        SpringApplication.run(BootRestApp.class, args);
    }   
}
