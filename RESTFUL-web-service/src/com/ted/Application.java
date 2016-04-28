package com.ted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static final String ROOT = "E:\\tmp";
	
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(new Object[]{Application.class,"/blog/integration.xml"}, args);
    }
    
}