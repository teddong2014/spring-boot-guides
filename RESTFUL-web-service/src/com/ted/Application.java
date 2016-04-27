package com.ted;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Application {
	
	public static final String ROOT = "E:\\tmp";
	
    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(Application.class, args);
    	System.out.println(new Date(1461754444480L));
    	System.out.println(new Date(1461754438669L));
    	System.out.println(new Date(1461754436855L));
    	System.out.println(new Date(1461754435723L));
    	System.out.println(new Date(1461754318026L));
    	System.out.println(new Date(1461754315784L));
    }
    
}